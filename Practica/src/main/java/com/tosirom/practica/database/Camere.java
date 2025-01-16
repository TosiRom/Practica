/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.database;

/**
 *
 * @author Skiuileuf
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * This class represents an employee.
 * It contains fields and methods for managing employees in the database.
 * 
 */
public class Camere {
    public int ID;
    public String Numar;
    public String Etaj;
    public int Numar_Paturi;
    public Boolean Balcon;
    
    public Camere() {}
    public Camere( 
        int ID,
        String Numar,
        String Etaj,
        int Numar_Paturi,
        Boolean Balcon
    ) {
        this.ID = ID;
        this.Numar = Numar;
        this.Etaj = Etaj;
        this.Numar_Paturi = Numar_Paturi;
        this.Balcon = Balcon;
    }
    
    private static Camere _ReadCamere(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        String numar = result.getString("Numar");
        String etaj = result.getString("Etaj");
        int numarPaturi = result.getInt("Numar_Paturi");
        Boolean balcon = result.getBoolean("Balcon");

                
        Camere a = new Camere(id, numar, etaj, numarPaturi, balcon);
        return a;
    }
    
    public static ArrayList<Camere> GetAllCamere() {
        ArrayList<Camere> camereList = new ArrayList<>();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Camere";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                camereList.add(_ReadCamere(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return camereList;
    }
    
    public static Camere GetCamereById(int id) {
        Camere a = new Camere();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Camere WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            if (result.next()) {
                a = _ReadCamere(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return a;
    }
     public static boolean CreateCamere(Camere in) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "INSERT INTO Camere (Numar,Etaj,Numar_Paturi,Balcon) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, in.Numar);
            statement.setString(2, in.Etaj);
            statement.setInt(3,in.Numar_Paturi);
            statement.setBoolean(4, in.Balcon);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public static boolean UpdateCamere(Camere in) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "UPDATE Camere SET Numar = ?, Etaj = ?, Numar_Paturi = ?, Balcon = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, in.Numar);
            statement.setString(2, in.Etaj);
            statement.setInt(3,in.Numar_Paturi);
            statement.setBoolean(4, in.Balcon);
            statement.setInt(5,in.ID);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean DeleteCamere(Integer id) {

        try (Connection conn = Database.getConnection()) {
            String SQL = "DELETE FROM Camere WHERE ID = ?";
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
        return this.ID + ", " + this.Numar + ", " + this.Etaj + ", " + this.Numar_Paturi + ", " + this.Balcon + ".";
    }
}