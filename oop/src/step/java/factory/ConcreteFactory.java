package step.java.factory;

import org.json.JSONObject;
import step.java.library.Literature;


public interface ConcreteFactory {

    Literature create(JSONObject obj);


    String getLiteratureType();
}
