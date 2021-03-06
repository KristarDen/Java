package step.library.utils;

import org.json.JSONObject;
import step.library.models.Book;

import java.sql.*;

public class BookOrm {
    private Connection connection ;
    private final String PREFIX ;
    private final JSONObject config ;

    BookOrm(Connection connection, String PREFIX, JSONObject config) {
        this.connection = connection ;
        this.PREFIX = PREFIX ;
        this.config = config ;
    }

    public boolean isTableExists() {
        String query ;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle") ) {
            query = "SELECT COUNT(*) " +
                    "FROM USER_TABLES T " +
                    "WHERE T.TABLE_NAME = " +
                    "'" + PREFIX + "BOOKS'" ;
        } else {
            return false ;
        }
        try ( ResultSet res = connection
                .createStatement()
                .executeQuery( query ) ) {
            if( res.next() ) {
                return res.getInt( 1 ) == 1 ;
            }
        }
        catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.isTableExists: "
                            + ex.getMessage() ) ;
        }
        return false ;
    }

    public boolean installTable() {
        String query ;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle") ) {
            query = "CREATE TABLE " + PREFIX + "BOOKS (" +
                    "id       RAW(16) DEFAULT SYS_GUID() PRIMARY KEY," +
                    "author   NVARCHAR2(128) NOT NULL," +
                    "title    NVARCHAR2(128) NOT NULL," +
                    "cover    NVARCHAR2(128) )" ;
        } else {
            return false ;
        }
        try( Statement statement = connection.createStatement() ) {
            statement.executeUpdate( query ) ;
            return true ;
        } catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.installTable: " + ex.getMessage() + "\n" + query ) ;
        }
        return false ;
    }

    public boolean add( Book book ) {
        if( connection == null || book == null ) return false ;
        String query ;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle")
                || dbms.equalsIgnoreCase( "MySQL" ) )
        {
            query = "INSERT INTO " + PREFIX + "BOOKS " +
                    "(author,title,cover) VALUES(?,?,?) " ;
        } else {
            return false ;
        }
        try( PreparedStatement statement =
                     connection.prepareStatement( query ) ) {
            statement.setString( 1, book.getAuthor() ) ;
            statement.setString( 2, book.getTitle()  ) ;
            statement.setString( 3, book.getCover()  ) ;
            statement.executeUpdate() ;
            return true ;
        } catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.add: " + ex.getMessage() + "\n" + query ) ;
        }
        return false ;
    }

    public Book[] getList() {
        if( connection == null ) return null ;
        String query, queryCount ;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle")
                || dbms.equalsIgnoreCase( "MySQL" ) )
        {
            queryCount = "SELECT COUNT(*) FROM " + PREFIX + "BOOKS" ;
            query = "SELECT B.id, B.author, B.title, B.cover FROM "
                    + PREFIX + "BOOKS B";
        } else {
            return null ;
        }
        try( Statement statement = connection.createStatement() ) {
            ResultSet res = statement.executeQuery( queryCount ) ;
            res.next();
            int cnt = res.getInt( 1 ) ;
            res.close() ;
            res = statement.executeQuery( query ) ;
            Book[] ret = new Book[ cnt ] ;
            for( int i = 0; i < cnt; i++ ) {
                res.next() ;
                ret[ i ] = new Book(
                        res.getString( 1 ),
                        res.getString( 2 ),
                        res.getString( 3 ),
                        res.getString( 4 )
                ) ;
            }
            return ret ;
        } catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.getList: " + ex.getMessage() + "\n" + query ) ;
        }
        return null ;
    }

    public Book getBook(String id){
        if( connection == null ) return null ;
        String query;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle")
                || dbms.equalsIgnoreCase( "MySQL" ) )
        {
            query = "SELECT * FROM "
                    + PREFIX + "BOOKS "
                    +"WHERE id = '"+ id +"'";
        } else {

            return null ;
        }
        try( Statement statement = connection.createStatement() ) {
            ResultSet res = statement.executeQuery( query ) ;
            res.next();
            Book book = new Book(
                    res.getString( 1 ),
                    res.getString( 2 ),
                    res.getString( 3 ),
                    res.getString( 4 )
            ) ;
            return book;
        } catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.getBook: " + ex.getMessage() + "\n" + query ) ;
        }
        return null ;
    }

    public boolean updateBook(String id, String author, String title){
        if( connection == null ) return false;
        String query;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle")
                || dbms.equalsIgnoreCase( "MySQL" ) )
        {
            query = "UPDATE "
                    + PREFIX + "BOOKS"
                    + " SET author = " + author
                    + " title = " + title
                    +" WHERE id = '"+ id +"'";
        } else {

            return false ;
        }
        try( Statement statement = connection.createStatement() ) {
            statement.executeQuery( query ) ;
            return true;

        } catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.updateBook: " + ex.getMessage() + "\n" + query ) ;
        }
        return false ;
    }

    public boolean deleteBook(String id){
        if( connection == null ) return false;
        String query;
        String dbms = config.getString( "dbms" ) ;
        if( dbms.equalsIgnoreCase( "Oracle")
                || dbms.equalsIgnoreCase( "MySQL" ) )
        {
            query = "DELETE FROM"
                    + PREFIX + "BOOKS"
                    + " WHERE id = '"+ id +"'";
        } else {

            return false ;
        }
        try( Statement statement = connection.createStatement() ) {
            statement.executeQuery( query ) ;
            return true;
        } catch( SQLException ex ) {
            System.err.println(
                    "BookOrm.DeleteBook: " + ex.getMessage() + "\n" + query ) ;
        }
        return false ;
    }

}
