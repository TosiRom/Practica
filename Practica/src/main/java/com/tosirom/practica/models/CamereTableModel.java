/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.models;

import com.tosirom.practica.database.Angajati;
import com.tosirom.practica.database.Camere;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Skiuileuf
 */

/**
 *     public int ID;
    public String Numar;
    public String Etaj;
    public int Numar_Paturi;
    public Boolean Balcon;
 * @author Skiuileuf
 */

public class CamereTableModel  extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "Numar", "Etaj", "Numar Paturi", "Balcon"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, String.class, String.class, Integer.class, Boolean.class,};        
    
    private Set<Integer> selected;
    private List<Camere> camere;
    
    public CamereTableModel() {
        selected = new TreeSet<>();
        camere = new ArrayList<>(25);
    }
    
    @Override
    public int getRowCount() {
        return camere.size();
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
        Camere client = camere.get(rowIndex);
        switch (columnIndex) {
            case 0: return client.ID;
            case 1: return client.Numar;
            case 2: return client.Etaj;
            case 3: return client.Numar_Paturi;
            case 4: return client.Balcon;
            
        }
        return null;
    }
    
     public void add(Camere client) {
        int index = camere.size();
        camere.add(client);
        fireTableRowsInserted(index, index);
    }

    public Camere cardAt(int rowIndex) {
        return camere.get(rowIndex);
    }
    
}
