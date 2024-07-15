package com.tosirom.practica.models;
import com.tosirom.practica.database.Inchirieri;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Set;
import java.sql.Date;
import java.util.TreeSet;

public class InchirieriTableModel  extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "ID Client","ID Produs", "Data Inchiriere","Data Returnare","Returnat"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, Integer.class, Integer.class, Date.class, Date.class,Boolean.class};        
    
    private Set<Integer> selected;
    private List<Inchirieri> inchirieri;
    
    public InchirieriTableModel() {
        selected = new TreeSet<>();
        inchirieri = new ArrayList<>(25);
    }
    
    @Override
    public int getRowCount() {
        return inchirieri.size();
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
        Inchirieri client = inchirieri.get(rowIndex);
        switch (columnIndex) {
            case 0: return client.ID;
            case 1: return client.ID_Client;
            case 2: return client.ID_Produs;
            case 3: return client.Data_inchiriere;
            case 4: return client.Data_returnare;
            case 5: return client.Returnat;
        }
        return null;
    }
    
     public void add(Inchirieri client) {
        int index = inchirieri.size();
        inchirieri.add(client);
        fireTableRowsInserted(index, index);
    }

    public Inchirieri cardAt(int rowIndex) {
        return inchirieri.get(rowIndex);
    }
    
}