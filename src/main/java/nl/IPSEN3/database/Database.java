/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bernd
 */
public class Database {


    private Connection connection;
    private Statement statement;

    private static Database databaseInstance ;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized Database getInstance() {
        if(databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    private Database() {
        //Mike's DB settings
//        String url = "jdbc:mysql://localhost:3306/";
//        String user = "lions_club";
//        String password = "root";
//        String dbName = "lions_club";

        String url = "jdbc:mysql://127.0.0.1:3306/";
        String user = "root";
        String password = "";
        String dbName = "lions_club";

       /* String url = "";
        String user = "";
        String password = "";
        String dbName = "";*/


        try {
            this.connection = DriverManager.getConnection(url + dbName, user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
