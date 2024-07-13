/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class represents an inventory item.
 * It contains fields and methods for managing inventory items in the database.
 *  */
public class Inventar {
    public int ID;
    public int ID_Produs;
    public int Cantitate;
    
    public Inventar() {}
    public Inventar( 
        int ID,
        int ID_Produs,
        int Cantitate
    ) {
        this.ID = ID;
        this.ID_Produs = ID_Produs;
        this.Cantitate = Cantitate;
    }
    
    private static Inventar _ReadInventar(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        int id_produs = result.getInt("ID_Produs");
        int cantitate = result.getInt("Cantitate");
                
        Inventar inv = new Inventar(id, id_produs, cantitate);
        return inv;
    }
    
    public static ArrayList<Inventar> GetAllInventar() {
        ArrayList<Inventar> inventarList = new ArrayList<>();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Inventar";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                inventarList.add(_ReadInventar(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return inventarList;
    }
    
    public static Inventar GetInventarById(int id) {
        Inventar inv = new Inventar();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Inventar WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            if (result.next()) {
                inv = _ReadInventar(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return inv;
    }
    
    @Override
    public String toString() {
        return this.ID + ", " + this.ID_Produs + ", " + this.Cantitate + ".";
    }
}
