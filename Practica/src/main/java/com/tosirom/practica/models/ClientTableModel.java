/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.models;

import com.tosirom.practica.database.Client;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Skiuileuf
 */
public class ClientTableModel extends AbstractTableModel {

    protected static String[] COLUMN_NAMES = {"ID", "Nume", "Prenume", "Adresa", "Telefon", "Email"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, String.class, String.class, String.class, String.class, String.class};

    private Set<Integer> selected;
    private List<Client> clients;

    public ClientTableModel() {
        selected = new TreeSet<Integer>();
        clients = new ArrayList<Client>(25);
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_CLASSES[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.ID;
            case 1:
                return client.Nume;
            case 2:
                return client.Prenume;
            case 3:
                return client.Adresa;
            case 4:
                return client.Telefon;
            case 5:
                return client.Email;
        }
        return null;
    }
    //    protected static String[] COLUMN_NAMES = {"ID", "Nume", "Prenume", "Adresa", "Telefon", "Email"};
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch (columnIndex) {
//            case 0:
//                client.ID;
//                break;
            case 1:
                client.Nume = (String)aValue;
                break;
            case 2:
                client.Prenume = (String)aValue;
                break;
            case 3:
                client.Adresa = (String)aValue;
                break;
            case 4:
                client.Telefon = (String)aValue;
                break;
            case 5:
                client.Email = (String)aValue;
                break;
        }
        // Update the database
        updateDatabse(client);
        // Notify listeners that the data has changed
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    private void updateDatabse(Client c) {
        Client.UpdateClient(c);
    }

    public void add(Client client) {
        int index = clients.size();
        clients.add(client);
        fireTableRowsInserted(index, index);
    }

    public Client clientAt(int rowIndex) {
        return clients.get(rowIndex);
    }

}
