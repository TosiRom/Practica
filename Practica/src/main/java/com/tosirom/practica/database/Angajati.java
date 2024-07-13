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
import java.sql.Date;

/**
 * This class represents an employee.
 * It contains fields and methods for managing employees in the database.
 * 
 */
public class Angajati {
    public int ID;
    public String Nume;
    public String Prenume;
    public String Functie;
    public Date Data_Angajare;
    public String Parola;
    
    public Angajati() {}
    public Angajati( 
        int ID,
        String Nume,
        String Prenume,
        String Functie,
        Date Data_Angajare,
        String Parola
    ) {
        this.ID = ID;
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.Functie = Functie;
        this.Data_Angajare = Data_Angajare;
        this.Parola = Parola;
    }
    
    private static Angajati _ReadAngajati(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        String nume = result.getString("Nume");
        String prenume = result.getString("Prenume");
        String functie = result.getString("Functie");
        Date data_angajare = result.getDate("Data_Angajare");
        String parola = result.getString("Parola");
                
        Angajati a = new Angajati(id, nume, prenume, functie, data_angajare, parola);
        return a;
    }
    
    public static ArrayList<Angajati> GetAllAngajati() {
        ArrayList<Angajati> angajatiList = new ArrayList<>();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Angajati";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            while (result.next()) {
                angajatiList.add(_ReadAngajati(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return angajatiList;
    }
    
    public static Angajati GetAngajatiById(int id) {
        Angajati a = new Angajati();
        
        try(Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Angajati WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            
            if (result.next()) {
                a = _ReadAngajati(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return a;
    }
    
    @Override
    public String toString() {
        return this.ID + ", " + this.Nume + ", " + this.Prenume + ", " + this.Functie + ", " + this.Data_Angajare + ", " + this.Parola + ".";
    }
}
