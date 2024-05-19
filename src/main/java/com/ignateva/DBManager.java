package com.ignateva;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private DBManager(){}
    private static final Properties PROPERTIES= new Properties();
    private static final String DB_URL;

    static{
        try(InputStream in = DBManager.class.getClassLoader().getResourceAsStream("db.properties")){
            PROPERTIES.load(in);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        DB_URL=PROPERTIES.getProperty("url");
    }

    static public Connection createConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  DriverManager.getConnection(DB_URL,PROPERTIES);
    }


}
