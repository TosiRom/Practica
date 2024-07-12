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
 *
 * @author Skiuileuf
 */
public class Client {
    public int ID;
    public String Nume;
    public String Prenume;
    public String Adresa;
    public String Telefon;
    public String Email;
    
    public Client() {}
    public Client( 
        int ID,
        String Nume,
        String Prenume,
        String Adresa,
        String Telefon,
        String Email
    ) {
        this.ID = ID;
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.Adresa = Adresa;
        this.Telefon = Telefon;
        this.Email = Email;
    }
    
    private static Client _ReadClient(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        String nume = result.getString("Nume");
        String prenume = result.getString("Prenume");
        String adresa = result.getString("Adresa");
        String telefon = result.getString("Telefon");
        String email = result.getString("Email");
                
        Client c = new Client(id, nume, prenume, adresa, telefon, email);
        return c;
    }
    
    public static ArrayList<Client> GetAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Clienti";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                clients.add(_ReadClient(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return clients;
    }
    
    public static Client GetClientById(int id) {
        Client c = new Client();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Clienti WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            c = _ReadClient(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return c;
    }
    
    @Override
    public String toString() {
        return this.ID + ", " + this.Nume + ", " + this.Prenume + ", " + this.Adresa + ", " + this.Telefon + ", " + this.Email + ".";
    }
}
