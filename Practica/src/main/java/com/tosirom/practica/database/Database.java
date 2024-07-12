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
    private static Database INSTANCE;
    
    private static final String databaseURL = "C:\\Users\\Skiuileuf\\Documents\\Github\\Practica\\Practica\\database.accdb";
    private static final String databaseProtocol = "jdbc:ucanaccess:///";
    public static final String connUrl = databaseProtocol + databaseURL;
    
    private Connection connection;
    
    public Connection getConnection() {
        return connection;
    }
    
    private Database() {
        String connectionURL = databaseProtocol + databaseURL;
        
        try {
            Connection connection = DriverManager.getConnection(connectionURL);
            this.connection = connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Database getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Database();
        }
        
        return INSTANCE;
    }
}
