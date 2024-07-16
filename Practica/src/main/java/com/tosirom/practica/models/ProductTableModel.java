/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.models;

import com.tosirom.practica.database.Inchirieri;
import com.tosirom.practica.database.Produse;
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
public class ProductTableModel extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "Tip", "Titlu", "Gen", "An Lansare", "Disponibil", "Pret Inchiriere"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, String.class, String.class, String.class, Integer.class, Boolean.class, Integer.class};        
    
    private Set<Integer> selected;
    private List<Produse> products;
    
    public ProductTableModel() {
        selected = new TreeSet<Integer>();
        products = new ArrayList<Produse>(25);
    }
    
    @Override
    public int getRowCount() {
        return products.size();
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
        Produse client = products.get(rowIndex);
        switch (columnIndex) {
            case 0: return client.ID;
            case 1: return client.Tip;
            case 2: return client.Titlu;
            case 3: return client.Gen;
            case 4: return client.An_Lansare;
            case 5: return client.Disponibil;
            case 6: return client.Pret_Inchiriere;
        }
        return null;
    }
      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produse client = products.get(rowIndex);
        switch (columnIndex) {
//            case 0:
//                client.ID;
//                break;
            case 1:
                client.Tip = (String)aValue;
                break;
            case 2:
                client.Titlu = (String)aValue;
                break;
            case 3:
                client.Gen = (String)aValue;
                break;
            case 4:
                client.An_Lansare = (int)aValue;
                break;
            case 5:
                client.Disponibil = (Boolean)aValue;
                break;
            case 6:
                client.Pret_Inchiriere = (int)aValue;
                break;
        }
        // Update the database
        updateDatabse(client);
        // Notify listeners that the data has changed
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
      private void updateDatabse(Produse p) {
        Produse.UpdateProduse(p);
    }
    
     public void add(Produse client) {
        int index = products.size();
        products.add(client);
        fireTableRowsInserted(index, index);
    }

    public Produse cardAt(int rowIndex) {
        return products.get(rowIndex);
    }
    
}
