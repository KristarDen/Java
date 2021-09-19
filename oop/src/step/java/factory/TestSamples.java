package step.java.factory;

import org.json.JSONObject;
import step.java.library.Book;

public class TestSamples {

    public static JSONObject getJsonBook() {
        JSONObject book = new JSONObject();
        book.put( "type", "Book");
        book.put( "author", "Jack London");
        book.put( "title", "Martin Eden");

        return book;
    }

    public static JSONObject getJsonJournal() {
        JSONObject jrnl = new JSONObject();
        jrnl.put( "type", "Journal" ) ;
        jrnl.put( "number", "2021, 1" ) ;
        jrnl.put( "title", "Quantum Mechanics" ) ;
        return jrnl ;
    }

    public static JSONObject getJsonNewspaper() {
        JSONObject newspaper = new JSONObject();
        newspaper.put( "type", "Newspaper");
        newspaper.put( "release_date", "Wed, Jul 4, '01");
        newspaper.put( "title", "Dumskaya");

        return newspaper;
    }

    public static JSONObject getJsonInvalidType() {
        JSONObject obj = new JSONObject();
        obj.put( "type", "Invalid" ) ;
        obj.put( "number", "2021, 1" ) ;
        obj.put( "title", "Quantum Mechanics" ) ;
        obj.put( "author", "Jack London");
        return obj ;
    }
}
