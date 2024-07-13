/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;

/**
 * This class represents a rental.
 * It contains fields and methods for managing rentals in the database.
 * 
 */
public class Inchirieri {
    public int ID;
    public int ID_Client;
    public int ID_Produs;
    public Date Data_inchiriere;
    public Date Data_returnare;
    public boolean Returnat;
    
    public Inchirieri() {}
    public Inchirieri( 
        int ID,
        int ID_Client,
        int ID_Produs,
        Date Data_inchiriere,
        Date Data_returnare,
        boolean Returnat
    ) {
        this.ID = ID;
        this.ID_Client = ID_Client;
        this.ID_Produs = ID_Produs;
        this.Data_inchiriere = Data_inchiriere;
        this.Data_returnare = Data_returnare;
        this.Returnat = Returnat;
    }
    
    private static Inchirieri _ReadInchirieri(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        int id_client = result.getInt("ID_Client");
        int id_produs = result.getInt("ID_Produs");
        Date data_inchiriere = result.getDate("Data_inchiriere");
        Date data_returnare = result.getDate("Data_returnare");
        boolean returnat = result.getBoolean("Returnat");
                
        Inchirieri i = new Inchirieri(id, id_client, id_produs, data_inchiriere, data_returnare, returnat);
        return i;
    }
    
    public static ArrayList<Inchirieri> GetAllInchirieri() {
        ArrayList<Inchirieri> inchirieriList = new ArrayList<>();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Inchirieri";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                inchirieriList.add(_ReadInchirieri(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return inchirieriList;
    }
    
    public static Inchirieri GetInchirieriById(int id) {
        Inchirieri i = new Inchirieri();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Inchirieri WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            if (result.next()) {
                i = _ReadInchirieri(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return i;
    }
    
    @Override
    public String toString() {
        return this.ID + ", " + this.ID_Client + ", " + this.ID_Produs + ", " + this.Data_inchiriere + ", " + this.Data_returnare + ", " + this.Returnat + ".";
    }
}
