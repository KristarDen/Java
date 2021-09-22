package step.java.factory;

import org.junit.Assert;
import org.junit.Test;
import step.java.library.Book;
import step.java.library.Journal;
import step.java.library.Literature;
import step.java.library.Newspaper;

import static org.junit.Assert.*;

public class LiteratureFactoryTest {

    @Test
    public void registerFactory() {
        BookFactory bookFactory = new BookFactory() ;
        JournalFactory journalFactory = new JournalFactory() ;
        NewspaperFactory newspaperFactory = new NewspaperFactory();
        LiteratureFactory literatureFactory = new LiteratureFactory() ;

        Assert.assertTrue(
                literatureFactory.registerFactory( bookFactory ) ) ;
        Assert.assertFalse(
                literatureFactory.registerFactory( bookFactory ) ) ;

        Assert.assertTrue(
                literatureFactory.registerFactory( journalFactory ) ) ;
        Assert.assertFalse(
                literatureFactory.registerFactory( journalFactory ) ) ;

        Assert.assertTrue(
                literatureFactory.registerFactory( newspaperFactory ) );
        Assert.assertFalse(
                literatureFactory.registerFactory( newspaperFactory ) );

    }
    @Test
    public void createFrom(){
        BookFactory bookFactory = new BookFactory();
        JournalFactory journalFactory = new JournalFactory();
        NewspaperFactory newspaperFactory = new NewspaperFactory();
        LiteratureFactory literatureFactory = new LiteratureFactory();

        literatureFactory.registerFactory( bookFactory );
        literatureFactory.registerFactory( journalFactory );
        literatureFactory.registerFactory( newspaperFactory );

        Literature lit;
        lit = literatureFactory.createFrom( TestSamples.getJsonBook() );
        Assert.assertTrue ( lit instanceof Book );

        lit = literatureFactory.createFrom( TestSamples.getJsonJournal() );
        Assert.assertTrue ( lit instanceof Journal);

        lit = literatureFactory.createFrom( TestSamples.getJsonNewspaper() );
        Assert.assertTrue( lit instanceof Newspaper);

        lit = literatureFactory.createFrom( TestSamples.getJsonInvalidType());
        Assert.assertNull (lit);
    }
}