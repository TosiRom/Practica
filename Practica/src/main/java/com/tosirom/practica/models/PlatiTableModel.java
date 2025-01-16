package com.tosirom.practica.models;

import com.tosirom.practica.database.Plati; 
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PlatiTableModel extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "Suma", "Metoda", "Data", "Id_Inchiriere"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, Double.class, String.class, Date.class, Integer.class};

    private List<Plati> plati;

    public PlatiTableModel() {
        plati = new ArrayList<>(25);
    }

    @Override
    public int getRowCount() {
        return plati.size();
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
        Plati plata = plati.get(rowIndex);
        switch (columnIndex) {
            case 0: return plata.ID;
            case 1: return plata.Suma;
            case 2: return plata.Metoda;
            case 3: return plata.Data;
            case 4: return plata.Id_Inchiriere;
        }
        return null;
    }

    public void add(Plati plata) {
        int index = plati.size();
        plati.add(plata);
        fireTableRowsInserted(index, index);
    }

    public Plati cardAt(int rowIndex) {
        return plati.get(rowIndex);
    }
}
