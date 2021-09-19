package step.java.library;

import java.util.ArrayList;

public class Library {
    // Aggregation - collection of ...
    private ArrayList<Literature> funds ;   // Funds
    // = new ArrayList<>() ;  // Not recommend: code/declaration mixing

    public Library() {
        funds = new ArrayList<>() ;  // OK
    }

    public void add( Literature lit ) {
        funds.add( lit ) ;
    }

    public void print() {
        /* for( Literature lit : funds ) {
            lit.print() ;
            System.out.println() ;  // new line
        } */
        // print() seems to be unnecessary in Literature class
        /*
        for( Literature lit : funds ) {
            if( lit instanceof Book ) {
                ( (Book) lit ).print() ;
            }
        }  // reduces scalability - we should add code for each new class
         */
        // The problem: some funds are printable, some aren't
        //  we want to add Holograms
        for( Literature lit : funds ) {
            if( lit instanceof Printable ) {
                ( (Printable) lit).print();
                System.out.println() ;  // new line
            }
        }
    }
}
