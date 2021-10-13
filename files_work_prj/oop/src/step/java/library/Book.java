package step.java.library;

import org.json.JSONObject;

public class Book
        extends Literature      // extension - inheritance
        implements Printable {  // interface implementation

    // Book( "Martin Eden", "Jack London" )
    private String author ;

    public Book( String title, String author ) {
        // this.title - error, no access
        // this.setTitle( title ) ;  // warning
        super.setTitle( title ) ;  // OK
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void print() {
        System.out.printf(
                "Book: %s (by %s)",
                super.getTitle(),
                author
        );
    }
    @Override
    public String toString() {
        return  this.getTitle() + " " + this.author;
    }

    @Override
    public String toJsonString(){
        JSONObject json = new JSONObject();
        json.append("author", this.author);
        json.append("title" , this.getTitle() );
        return  json.toString();
    }

}
