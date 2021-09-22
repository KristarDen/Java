package step.java.factory;

import org.json.JSONObject;
import step.java.library.Book;

public class TestSamples {

    private static JSONObject
        book, journal, newspaper, invalid;

    public static JSONObject getJsonBook() {

        if ( book == null ){
            book = new JSONObject();
            book.put( "type", "Book");
            book.put( "author", "Jack London");
            book.put( "title", "Martin Eden");
        }

        return book;
    }

    public static JSONObject getJsonJournal() {
        if(journal == null) {
            journal = new JSONObject();
            journal.put( "type", "Journal" ) ;
            journal.put( "number", "2021, 1" ) ;
            journal.put( "title", "Quantum Mechanics" ) ;
        }

        return journal ;
    }

    public static JSONObject getJsonNewspaper() {
        if (newspaper == null){
            newspaper = new JSONObject();
            newspaper.put( "type", "Newspaper");
            newspaper.put( "release_date", "Wed, Jul 4, '01");
            newspaper.put( "title", "Dumskaya");
        }
        return newspaper;
    }

    public static JSONObject getJsonInvalidType() {
        if(invalid == null){
            invalid = new JSONObject();
            invalid.put( "type", "Invalid" ) ;
            invalid.put( "number", "2021, 1" ) ;
            invalid.put( "title", "Quantum Mechanics" ) ;
            invalid.put( "author", "Jack London");
        }

        return invalid ;
    }
}
