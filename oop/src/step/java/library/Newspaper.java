package step.java.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Newspaper
        extends Literature
        implements Printable {

    private  String  release_date;

    public  Newspaper(String title, String release_date) {
        super.setTitle(title);


        this.release_date= release_date;
    }

    public void setDate(String date) {

        this.release_date = date;
    }

    public String getDate() {
        return this.release_date.toString();
    }

    @Override
    public  void print(){
        System.out.printf(
                "Newspaper: \"%s\" , publication date: %s",
                super.getTitle(),
                getDate()
        );
    }
}