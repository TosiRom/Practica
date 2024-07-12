/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tosirom.practica;

import com.tosirom.practica.database.Client;
import com.tosirom.practica.ui.MainFrame;
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
    
        var a = Client.GetAllClients();
        
        for(int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

        MainFrame mf = new MainFrame();
        
        mf.setVisible(true);
    }
}
