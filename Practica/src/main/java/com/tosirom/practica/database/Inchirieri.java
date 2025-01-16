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
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * This class represents a rental.
 * It contains fields and methods for managing rentals in the database.
 * 
 */
public class Inchirieri {
    public int ID;
    public int ID_Client;
    public int ID_Camera;
    public Date Data_inchiriere;
    public Date Data_returnare;
    public boolean Returnat;
    
    public Inchirieri() {}
    public Inchirieri( 
        int ID,
        int ID_Client,
        int ID_Camera,
        Date Data_inchiriere,
        Date Data_returnare,
        boolean Returnat
    ) {
        this.ID = ID;
        this.ID_Client = ID_Client;
        this.ID_Camera = ID_Camera;
        this.Data_inchiriere = Data_inchiriere;
        this.Data_returnare = Data_returnare;
        this.Returnat = Returnat;
    }
    
    private static Inchirieri _ReadInchirieri(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        int id_client = result.getInt("ID_Client");
        int id_camera = result.getInt("ID_Camera");
        Date data_inchiriere = result.getDate("Data_inchiriere");
        Date data_returnare = result.getDate("Data_returnare");
        boolean returnat = result.getBoolean("Returnat");
                
        Inchirieri i = new Inchirieri(id, id_client, id_camera, data_inchiriere, data_returnare, returnat);
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
     public static boolean CreateInchirieri(Inchirieri i) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "INSERT INTO Inchirieri(ID_Client, ID_Produs, Data_Inchiriere, Data_Returnare, Returnat) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, i.ID_Client);
            statement.setInt(2, i.ID_Camera);
            statement.setDate(3, i.Data_inchiriere);
            statement.setDate(4, i.Data_returnare);
            statement.setBoolean(5, i.Returnat);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public static boolean UpdateInchirieri(Inchirieri i) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "UPDATE Inchirieri SET ID_Client = ?, ID_Produs = ?, Data_Inchiriere = ?, Data_Returnare = ?, Returnat = ? WHERE ID = ?";
             PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, i.ID_Client);
            statement.setInt(2, i.ID_Camera);
            statement.setDate(3, i.Data_inchiriere);
            statement.setDate(4, i.Data_returnare);
            statement.setBoolean(5, i.Returnat);
            statement.setInt(6, i.ID);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean DeleteInchirieri(Integer id) {

        try (Connection conn = Database.getConnection()) {
            String SQL = "DELETE FROM Inchirieri WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    @Override
    public String toString() {
        return this.ID + ", " + this.ID_Client + ", " + this.ID_Camera + ", " + this.Data_inchiriere + ", " + this.Data_returnare + ", " + this.Returnat + ".";
    }
}
