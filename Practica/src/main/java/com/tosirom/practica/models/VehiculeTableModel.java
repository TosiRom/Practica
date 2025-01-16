package com.tosirom.practica.models;

import com.tosirom.practica.database.Vehicule; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VehiculeTableModel extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "Numar Inmatriculare", "ID Client", "Marca/Model Vehicul"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, String.class, Integer.class, String.class};

    private List<Vehicule> vehicule;

    public VehiculeTableModel() {
        vehicule = new ArrayList<>(25);
    }

    @Override
    public int getRowCount() {
        return vehicule.size();
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
        Vehicule vehicul = vehicule.get(rowIndex);
        switch (columnIndex) {
            case 0: return vehicul.ID;
            case 1: return vehicul.Numar_Inmatriculare;
            case 2: return vehicul.ID_Client;
            case 3: return vehicul.Marca_Model_Vehicul;
        }
        return null;
    }

    public void add(Vehicule vehicul) {
        int index = vehicule.size();
        vehicule.add(vehicul);
        fireTableRowsInserted(index, index);
    }

    public Vehicule cardAt(int rowIndex) {
        return vehicule.get(rowIndex);
    }
}
