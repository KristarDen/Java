package step.java.fs;

import step.java.factory.BookFactory;
import step.java.factory.JournalFactory;
import step.java.factory.TestSamples;
import step.java.library.Book;
import step.java.library.Journal;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Create files for library funds
 */

public class CreateFiles {

    public void showDir() {

        File dir =  new File ( "./");
        SimpleDateFormat printer = new SimpleDateFormat(
                "dd.MM.yyyy HH:mm" );
        if ( dir.isDirectory() ) {
            //get files list
            for (File f : dir.listFiles() ){
                System.out.printf(
                        "%s\t%s\t%s%n",
                        printer.format(f.lastModified()),
                        f.isDirectory()
                                ? "<DIR>"
                                : f.length() + "",
                        f.getName()
                );
            }
        } else {
            System.err.println( "Path not found" );
        }
    }

    public void createBook(){
        Book book = (Book) new BookFactory()
                .create(TestSamples.getJsonBook());
        String filename = "./src/step/java/fs/"
                + book.getAuthor()
                + "_" + book.getTitle()
                + ".json" ;
        File file = new File ( filename );
        // Writing file: stream API
        // try () {} catch (){}

        try(
            OutputStream writer =
                  new FileOutputStream( file )
        ){
            writer.write(
                    TestSamples.getJsonBook()
                    .toString().getBytes()
            );
            writer.flush() ;
            System.out.println( filename );
        } catch ( IOException ex ){
            System.err.printf( ex.getMessage() + ": " + filename);
        }
    }

    public void createJournal() {
        Journal journal = (Journal) new JournalFactory()
                .create(TestSamples.getJsonJournal());
        String filename = "./src/step/java/fs/"
                + journal.getNumber()
                + "_" + journal.getTitle()
                + ".json" ;
        File file = new File ( filename );

        try(OutputStream writer =
                        new FileOutputStream( file )
        ){
            writer.write(
                    TestSamples.getJsonJournal()
                            .toString().getBytes()
            );
            writer.flush() ;
            System.out.println( filename );
        } catch ( IOException ex ){
            System.err.printf( ex.getMessage() + ": " + filename);
        }
    }
}
/*
    Работа с файлами.
    1. Работа с файловой системой ( список файлов,
     копировать, удалить, проверить наличие, создать
     каталог и т.п.)
    2. Работа с файлами как с данными ( открыть, читать,
        писать)
 */