package step.java.excercises;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Db {

    private final String PREFIX = "KH181_9_";

    public void demo(){
        // Registering driver


        // Loading config
        File file = new File(
                ".\\oop\\src\\step\\java\\config\\db.json");
        if ( !file.exists() ){
            System.err.println( "Config location error" );
            return;
        }



        JSONObject conf ;
        String connectionString;
                try{
                   conf =  new JSONObject(
                           new String(
                                   new FileInputStream(file)
                                        .readAllBytes()));
                    connectionString = String.format(
                            "jdbc:oracle:thin:%s/%s@%s:%d:XE",
                            conf.getString("user"),
                            conf.getString("pass"),
                            conf.getString("host"),
                            conf.getInt("port")
                            );
                }catch ( IOException ex ){
                    System.err.println( ex.getMessage() );
                    return;
                }

                Connection connection ;
                try {

                    DriverManager.registerDriver(
                    //Don't forget add OJDBC8.JAR library
                    new oracle.jdbc.driver.OracleDriver()
                    );

                    connection = DriverManager.getConnection(
                            connectionString
                    );

                } catch ( SQLException ex ){

                    System.err.println( ex.getMessage() );
                    return;
                }
                // Queries
                //Update-Queries: DDL + DML (except SELECT)
                /*String query = "INSERT INTO " + PREFIX + "exercise( name , id_parent ) "
                        + "VALUES( 'Olegovich' , (SELECT id FROM "
                        + PREFIX + "exercise WHERE name='Valentinch') ) ";*/
                String query = String.format(
                        "INSERT INTO %sexercise( name, id_parent ) " +
                        "VALUES( '%s', (SELECT id FROM %sexercise WHERE name='%s') )",

                        PREFIX,"Grigorievna", PREFIX, "Olegovich"
                );

                /*try( Statement statement = connection.createStatement() ){
                    // statement ~ SqlCommand
                    statement.executeUpdate( query ) ;
                }
                catch ( SQLException ex ){

                    System.err.println( ex.getMessage() );
                    return;
                }*/
                try( Statement statement = connection.createStatement() ){
                // statement ~ SqlCommand

                statement.executeUpdate( query ) ;
                }
                catch ( SQLException ex ){

                    System.err.println( ex.getMessage() );
                    return;
                }
                //System.out.println( connectionString );
    }


}


/*
    Работа с базами данных
    База данных - способ организации данных, при котором
        кроме данных создаются связи между ними.
    По видам связей БД
        Табличные БД (обычные, SQL-БД)
        Сетвые БД (Grid)
        Графовые (GraphQL)
        ООП
 */