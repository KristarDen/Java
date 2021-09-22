package step.java.factory;

import org.json.JSONObject;
import step.java.library.Literature;

import java.util.ArrayList;

public class LiteratureFactory {

    private ArrayList<ConcreteFactory> factories ;

    public LiteratureFactory() {
        factories = new ArrayList<>() ;
    }


    public boolean registerFactory( ConcreteFactory factory ) {
        if( factories.contains( factory ) ) {
            return false ;
        }
        factories.add( factory ) ;
        return true ;
    }


    Literature createFrom( JSONObject obj ) {

        for ( ConcreteFactory factory : factories ){
            Literature lit = factory.create( obj );
            if ( lit != null ) return  lit;
        }
        return null ;
    }
}
