package com.tosirom.practica.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 
 */
public class InventarCamera {
    public int ID_Camera;
    public int ID_Produs;
    public int Cantitate;

    public InventarCamera() {}

    public InventarCamera(
        int ID_Camera,
        int ID_Produs,
        int Cantitate
    ) {
        this.ID_Camera = ID_Camera;
        this.ID_Produs = ID_Produs;
        this.Cantitate = Cantitate;
    }

    private static InventarCamera _ReadInventarCamera(ResultSet result) throws SQLException {
        int idCamera = result.getInt("ID_Camera");
        int idProdus = result.getInt("ID_Produs");
        int cantitate = result.getInt("Cantitate");

        return new InventarCamera(idCamera, idProdus, cantitate);
    }

    public static ArrayList<InventarCamera> GetAllInventarCamera() {
        ArrayList<InventarCamera> inventarList = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM InventarCamera";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            while (result.next()) {
                inventarList.add(_ReadInventarCamera(result));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return inventarList;
    }
     public static boolean CreateInventarCamera(Inventar in) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "INSERT INTO InventarCamere(ID_Produs,Cantaite) VALUES (?,?)";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, in.ID_Produs);
            statement.setInt(2, in.Cantitate);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public static boolean UpdateInventarCamera(Inventar in) {
        try (Connection conn = Database.getConnection()) {
            String SQL = "UPDATE InventarCamere SET ID_Produs = ?, Cantitate = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, in.ID_Produs);
            statement.setInt(2, in.Cantitate);
            statement.setInt(3, in.ID);
            statement.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean DeleteInventarCamera(Integer id) {

        try (Connection conn = Database.getConnection()) {
            String SQL = "DELETE FROM InventarCamera WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static InventarCamera GetInventarByCameraAndProdus(int idCamera, int idProdus) {
        InventarCamera inventar = null;

        try (Connection conn = Database.getConnection()) {
            String SQL = "SELECT * FROM InventarCamera WHERE ID_Camera = " + idCamera + " AND ID_Produs = " + idProdus;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            if (result.next()) {
                inventar = _ReadInventarCamera(result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return inventar;
    }

    @Override
    public String toString() {
        return "ID_Camera: " + this.ID_Camera + ", ID_Produs: " + this.ID_Produs + ", Cantitate: " + this.Cantitate;
    }
}
