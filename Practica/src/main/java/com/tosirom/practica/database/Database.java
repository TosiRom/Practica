/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.database;

import java.sql.*;

/**
 *
 * @author Skiuileuf
 */
public class Database { 
    private static final String databaseURL = System.getProperty("user.dir") + "\\database.accdb";
    private static final String databaseProtocol = "jdbc:ucanaccess:///";
    public static final String connUrl = databaseProtocol + databaseURL;

    
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(connUrl);
        return connection;
    }
}
