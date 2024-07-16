/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 */
public class Client {

    public Integer ID;
    public String Nume;
    public String Prenume;
    public String Adresa;
    public String Telefon;
    public String Email;

    public Client() {
    }

    public Client(
            Integer ID,
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
        Integer id = result.getInt("ID");
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

        try (Connection conn = Database.getConnection()) {
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

        try (Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Clienti WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            c = _ReadClient(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return c;
    }

    public static boolean CreateClient(Client c) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "INSERT INTO Clienti(Nume, Prenume, Adresa, Telefon, Email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, c.Nume);
            statement.setString(2, c.Prenume);
            statement.setString(3, c.Adresa);
            statement.setString(4, c.Telefon);
            statement.setString(5, c.Email);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean UpdateClient(Client c) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "UPDATE Clienti SET Nume = ?, Prenume = ?, Adresa = ?, Telefon = ?, Email = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, c.Nume);
            statement.setString(2, c.Prenume);
            statement.setString(3, c.Adresa);
            statement.setString(4, c.Telefon);
            statement.setString(5, c.Email);
            statement.setInt(6, c.ID);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean DeleteClient(Integer id) {

        try (Connection conn = Database.getConnection()) {
            String SQL = "DELETE FROM Clienti WHERE ID = ?";
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
        return this.ID + ", " + this.Nume + ", " + this.Prenume + ", " + this.Adresa + ", " + this.Telefon + ", " + this.Email + ".";
    }
}
