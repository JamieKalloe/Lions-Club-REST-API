/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Set;

import nl.ipsen3.ApiConfiguration;

public class Database {


    private Connection connection;
    private Statement statement;
    private static ApiConfiguration apiConfiguration;

    private static Database databaseInstance ;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized Database getInstance() {
        if(databaseInstance == null) {
            databaseInstance = new Database(apiConfiguration);
        }
        return databaseInstance;
    }
    
    public static synchronized Database getInstance(ApiConfiguration configuration) {
        if(databaseInstance == null) {
            databaseInstance = new Database(configuration);
            apiConfiguration = configuration;
        }
        return databaseInstance;
    }

    private Database(ApiConfiguration configuration) {
  
        String user = configuration.getDatabaseUser();
        String password = configuration.getDatabasePwd();
        String dbName = configuration.getDatabaseName();
        String url = "jdbc:mysql://"+configuration.getDatabaseURL()+"/";


        try {
            this.connection = DriverManager.getConnection(url + dbName, user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Select result set.
     *
     * @param from the from
     * @return the result set
     */

    public ResultSet select(String from) {
        String query = "SELECT * FROM `" + from+"`";
        ResultSet resultSet = queryDatabase(query);
        return resultSet;
    }

    /**
     * Select result set.
     *
     * @param from  the from
     * @param where the where
     * @return the result set
     */

    public ResultSet select(String from, String where) {
        String query = "SELECT * FROM `" + from + "` WHERE " + where;
        ResultSet resultSet = queryDatabase(query);
        System.out.println(query);
        return resultSet;
    }

    /**
     * Select result set.
     *
     * @param from the from
     * @param id   the id
     * @return the result set
     */

    public ResultSet select(String from, int id) {
        String query = "SELECT * FROM `" + from + "` WHERE id=" + id;
        ResultSet resultSet = queryDatabase(query);
        return resultSet;
    }

    /**
     * Select result set.
     *
     * @param from         the from
     * @param foreignTable the foreign table
     * @param resultColumn the result column
     * @param filterColumn the filter column
     * @param where        the where
     * @return the result set
     */

    public ResultSet select(String from, String foreignTable, String resultColumn, String filterColumn,String where) {
        String query = "SELECT * FROM `" + from + "` WHERE "+resultColumn+" IN ( SELECT "+filterColumn+" FROM "+foreignTable+ "` WHERE " + where +" )";
        ResultSet resultSet = queryDatabase(query);
        return resultSet;
    }

    /**
     * Insert into int.
     *
     * @param table the table
     * @param data  the data
     * @return the int
     */
    public int insertInto(String table, HashMap data) {
        String queryTable = "INSERT INTO `" + table + "` (";
        String queryValues = ") VALUES(";
        Set keySet = data.keySet();
        Object[] keyArray = keySet.toArray();
        for(int index = 0; index < keyArray.length; index++) {
            queryTable += ""+keyArray[index].toString()+"";
            if(data.get(keyArray[index])  instanceof  String ) {
                queryValues += "'"+data.get(keyArray[index]).toString()+"'";
            }
            else {
                queryValues += data.get(keyArray[index]).toString();
            }
            if(index != keyArray.length - 1) {
                queryTable += ", ";
                queryValues += ", ";
            }
        }
        int result = updateDatabase(queryTable + queryValues + ")", Statement.RETURN_GENERATED_KEYS);
        
        System.out.print(queryTable + queryValues + ")" + "  :::: " + result);
 
        return result;
    }

    /**
     * Update int.
     *
     * @param table the table
     * @param id    the id
     * @param data  the data
     * @return the int
     */
    public int update(String table, int id, HashMap data) {
        String query = "UPDATE `" + table + "` SET ";
        Set keySet = data.keySet();
        Object[] keyArray = keySet.toArray();
        for(int index = 0; index < keyArray.length; index++) {
            query += keyArray[index].toString()+"=";
            if(data.get(keyArray[index]) instanceof String ) {
                query += "'"+data.get(keyArray[index])+"'";
            }
            else {
                query += data.get(keyArray[index]).toString();
            }
            if(index != keyArray.length - 1) {
                query += ", ";
            }
        }
        query += " WHERE id="+id;
        System.out.println(query);
        int result = updateDatabase(query);
        return result;
    }

    /**
     * Update int.
     *
     * @param table the table
     * @param where the where
     * @param data  the data
     * @return the int
     */
    public int update(String table, String where, HashMap data) {
        String query = "UPDATE `" + table + "` SET ";
        Set keySet = data.keySet();
        Object[] keyArray = keySet.toArray();
        for(int index = 0; index < keyArray.length; index++) {
            query += keyArray[index].toString()+"=";
            if(data.get(keyArray[index]) instanceof String ) {
                query += "'"+data.get(keyArray[index])+"'";
            }
            else {
                query += data.get(keyArray[index]).toString();
            }
            if(index != keyArray.length - 1) {
                query += ", ";
            }
        }
        query += " WHERE " + where;
        System.out.println(query);
        
        int result = updateDatabase(query);
        return result;
    }

    /**
     * Delete int.
     *
     * @param from the from
     * @param id   the id
     * @return the int
     */
    public int delete(String from, int id) {
        String query = "DELETE FROM `"+from+"` WHERE id="+id;
        int result = updateDatabase(query);
        return result;
    }

    /**
     * Delete int.
     *
     * @param from  the from
     * @param where the where
     * @return the int
     */
    public int delete(String from, String where) {
        String query = "DELETE FROM `"+from+"` WHERE "+where;
        return updateDatabase(query);
    }

    /**
     * @return returns result set of executed query
     */
    private ResultSet queryDatabase(String query) {
        try {
            statement = databaseInstance.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int updateDatabase(String updateQuery) {
        try {
            statement = databaseInstance.connection.createStatement();
            int result = statement.executeUpdate(updateQuery);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int updateDatabase(String updateQuery, int settings) {
        try {
            statement = databaseInstance.connection.createStatement();
            int result = statement.executeUpdate(updateQuery, settings);
            try {
                ResultSet resultSet = statement.getGeneratedKeys();
                while(resultSet.next()) {
                    return resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static void killDataBaseInstance() {
        databaseInstance = null;
    };
}