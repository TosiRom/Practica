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
        return false;
    }

     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0: return client.ID;
            case 1: return client.Nume;
            case 2: return client.Prenume;
            case 3: return client.Adresa;
            case 4: return client.Telefon;
            case 5: return client.Email;
        }
        return null;
    }
    
     public void add(Client client) {
        int index = clients.size();
        clients.add(client);
        fireTableRowsInserted(index, index);
    }

    public Client cardAt(int rowIndex) {
        return clients.get(rowIndex);
    }
    
}
