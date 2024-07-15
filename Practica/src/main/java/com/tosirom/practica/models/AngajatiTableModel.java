package com.tosirom.practica.models;
import com.tosirom.practica.database.Angajati;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AngajatiTableModel  extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "Nume", "Prenume","Functie","Data Angajare"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, String.class, String.class, String.class, Date.class,};        
    
    private Set<Integer> selected;
    private List<Angajati> angajati;
    
    public AngajatiTableModel() {
        selected = new TreeSet<>();
        angajati = new ArrayList<>(25);
    }
    
    @Override
    public int getRowCount() {
        return angajati.size();
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
        Angajati client = angajati.get(rowIndex);
        switch (columnIndex) {
            case 0: return client.ID;
            case 1: return client.Nume;
            case 2: return client.Prenume;
            case 3: return client.Functie;
            case 4: return client.Data_Angajare;
            
        }
        return null;
    }
    
     public void add(Angajati client) {
        int index = angajati.size();
        angajati.add(client);
        fireTableRowsInserted(index, index);
    }

    public Angajati cardAt(int rowIndex) {
        return angajati.get(rowIndex);
    }
    
}
