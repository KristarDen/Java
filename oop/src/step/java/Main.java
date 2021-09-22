package step.java;

import step.java.fs.CreateFiles;
import step.java.library.Book;
import step.java.library.Hologram;
import step.java.library.Journal;
import step.java.library.Library;

public class Main {

    public static void main(String[] args) {
        /*Library lib = new Library() ;
        lib.add( new Journal( "Quantum Mechanics", "2021, 1" ) ) ;
        lib.add( new Book( "Martin Eden", "Jack London" ) ) ;
        lib.add( new Hologram( "Pectoral" ) ) ;
        lib.print() ;*/

        CreateFiles creator = new CreateFiles();
        //creator.showDir();
        creator.createBook();
        creator.createJournal();
    }
}
