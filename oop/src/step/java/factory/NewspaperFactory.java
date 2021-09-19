package step.java.factory;

import org.json.JSONException;
import org.json.JSONObject;
import step.java.library.Book;
import step.java.library.Literature;
import step.java.library.Newspaper;

public class NewspaperFactory implements ConcreteFactory{
    @Override
    public Literature create(JSONObject obj) {
        try{
            if(!"Newspaper".equals(obj.getString("type")))
                return null;

            return new Newspaper(
                    obj.getString("title"),
                    obj.getString("release_date")
            );
        }
        catch (JSONException ignored){
            return  null;
        }
    }

    @Override
    public String getLiteratureType() { return  "Newspaper";}
}
