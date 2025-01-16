package com.tosirom.practica.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 
 */
public class Vehicule {
    public int ID;
    public String Numar_Inmatriculare;
    public int ID_Client;
    public String Marca_Model_Vehicul;

    public Vehicule() {}

    public Vehicule(
        int ID,
        String Numar_Inmatriculare,
        int ID_Client,
        String Marca_Model_Vehicul
    ) {
        this.ID = ID;
        this.Numar_Inmatriculare = Numar_Inmatriculare;
        this.ID_Client = ID_Client;
        this.Marca_Model_Vehicul = Marca_Model_Vehicul;
    }

    private static Vehicule _ReadVehicule(ResultSet result) throws SQLException {
        int id = result.getInt("ID");
        String numarInmatriculare = result.getString("Numar_Inmatriculare");
        int idClient = result.getInt("ID_Client");
        String marcaModelVehicul = result.getString("Marca_Model_Vehicul");

        return new Vehicule(id, numarInmatriculare, idClient, marcaModelVehicul);
    }

    public static ArrayList<Vehicule> GetAllVehicule() {
        ArrayList<Vehicule> vehiculeList = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Vehicule";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            while (result.next()) {
                vehiculeList.add(_ReadVehicule(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehiculeList;
    }

    public static Vehicule GetVehiculById(int id) {
        Vehicule vehicul = null;

        try (Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM Vehicule WHERE ID = " + id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            if (result.next()) {
                vehicul = _ReadVehicule(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicul;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + ", Numar_Inmatriculare: " + this.Numar_Inmatriculare + ", ID_Client: " + this.ID_Client + ", Marca_Model_Vehicul: " + this.Marca_Model_Vehicul;
    }
}
