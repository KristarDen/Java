package step.java.library;

import org.json.JSONObject;

public class Journal
        extends Literature      // extension - inheritance
        implements Printable {  // interface implementation

    private String number ;  // Year, No (2021,1)

    public Journal( String title, String number ) {
        super.setTitle( title ) ;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void print() {
        System.out.printf(
                "Journal: %s (%s)",
                super.getTitle(),
                number
        );
    }


    @Override
    public String toString() {
        return  this.getTitle() + " " + this.number;
    }

    @Override
    public String toJsonString(){
        JSONObject json = new JSONObject();
        json.append("number", this.number);
        json.append("title" , this.getTitle() );
        return  json.toString();
    }
}
