package step.java.library;

import org.json.JSONObject;

public class Hologram
        extends Literature {

    public Hologram( String title ) {
        super.setTitle( title ) ;
    }


    @Override
    public String toString() {
        return  this.getTitle() ;
    }

    @Override
    public String toJsonString(){
        JSONObject json = new JSONObject();
        json.append("title" , this.getTitle() );
        return  json.toString();
    }
}
