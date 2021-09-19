package step.java.factory;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import step.java.library.Book;
import step.java.library.Journal;
import step.java.library.Newspaper;

public class NewspaperFactoryTest {
    @org.junit.Test
    public  void  create(){
        JSONObject newspaper =  TestSamples.getJsonNewspaper();
        JSONObject book = TestSamples.getJsonBook();

        NewspaperFactory factory = new NewspaperFactory();
        Assert.assertNull( factory.create( book ) );
        Assert.assertNull( factory.create( TestSamples.getJsonInvalidType() ) ) ;

        Newspaper testNewspaper = (Newspaper) factory.create(newspaper);
        Assert.assertNotNull( testNewspaper );
        Assert.assertEquals(
                newspaper.getString("title"),
                testNewspaper.getTitle()
        );

        Assert.assertEquals(
                newspaper.getString("release_date"),
                testNewspaper.getDate()
        );
    }

    @org.junit.Test
    public void getLiteratureType(){
        Assert.assertEquals(
                "Newspaper",
                new NewspaperFactory().getLiteratureType()
        );
    }
}
