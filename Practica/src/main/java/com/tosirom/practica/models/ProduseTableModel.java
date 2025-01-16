package com.tosirom.practica.models;

import com.tosirom.practica.database.Produse; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProduseTableModel extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "Denumire", "Pret"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, String.class, Double.class};

    private List<Produse> produse;

    public ProduseTableModel() {
        produse = new ArrayList<>(25);
    }

    @Override
    public int getRowCount() {
        return produse.size();
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
        Produse produs = produse.get(rowIndex);
        switch (columnIndex) {
            case 0: return produs.ID;
            case 1: return produs.Denumire;
            case 2: return produs.Pret;
        }
        return null;
    }

    public void add(Produse produs) {
        int index = produse.size();
        produse.add(produs);
        fireTableRowsInserted(index, index);
    }

    public Produse cardAt(int rowIndex) {
        return produse.get(rowIndex);
    }
}
