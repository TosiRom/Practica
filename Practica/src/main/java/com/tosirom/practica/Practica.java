/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tosirom.practica;

import com.tosirom.practica.database.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Skiuileuf
 */
public class Practica {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.dir") + "\\database.accdb");
        System.out.println(Database.connUrl);
        
        try {
                
            String SQL = "SELECT * FROM Produse";
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                int id = result.getInt("ID");
                String fullname = result.getString("Nume");
                 
                System.out.println(id + ", " + fullname);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        MainFrame mf = new MainFrame();
        
        mf.setVisible(true);
    }
}
