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
 * This class represents a product, which can be a movie, game, or music.
 * It contains fields and methods for managing these items in the database.
 * 
 */
public class Produse {
    public int ID;
    public String Tip;
    public String Titlu;
    public String Gen;
    public int An_Lansare;
    public boolean Disponibil;
    public int Pret_Inchiriere;
    
    public Produse() {}
    public Produse( 
        int ID,
        String Tip,
        String Titlu,
        String Gen,
        int An_Lansare,
        boolean Disponibil,
        int Pret_Inchiriere
    ) {
        this.ID = ID;
        this.Tip = Tip;
        this.Titlu = Titlu;
        this.Gen = Gen;
        this.An_Lansare = An_Lansare;
        this.Disponibil = Disponibil;
        this.Pret_Inchiriere = Pret_Inchiriere;
    }
    
    private static Produse _ReadProduse(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        String tip = result.getString("Tip");
        String titlu = result.getString("Titlu");
        String gen = result.getString("Gen");
        int an_lansare = result.getInt("An_Lansare");
        boolean disponibil = result.getBoolean("Disponibil");
        int pret_inchiriere = result.getInt("Pret_Inchiriere");
                
        Produse p = new Produse(id, tip, titlu, gen, an_lansare, disponibil, pret_inchiriere);
        return p;
    }
    
    public static ArrayList<Produse> GetAllProduse(String tableName) {
        ArrayList<Produse> produseList = new ArrayList<>();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM " + tableName;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                produseList.add(_ReadProduse(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return produseList;
    }
    
    public static Produse GetProduseById(String tableName, int id) {
        Produse p = new Produse();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM " + tableName + " WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            if (result.next()) {
                p = _ReadProduse(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return p;
    }
    
    @Override
    public String toString() {
        return this.ID + ", " + this.Tip + ", " + this.Titlu + ", " + this.Gen + ", " + this.An_Lansare + ", " + this.Disponibil + ", " + this.Pret_Inchiriere + ".";
    }
}