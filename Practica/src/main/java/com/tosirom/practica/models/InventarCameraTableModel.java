package com.tosirom.practica.models;

import com.tosirom.practica.database.InventarCamera;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class InventarCameraTableModel extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID_Camera", "ID_Produs", "Cantitate"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, Integer.class, Integer.class};

    private List<InventarCamera> inventarCamere;

    public InventarCameraTableModel() {
        inventarCamere = new ArrayList<>(25);
    }

    @Override
    public int getRowCount() {
        return inventarCamere.size();
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
        InventarCamera inventar = inventarCamere.get(rowIndex);
        switch (columnIndex) {
            case 0: return inventar.ID_Camera;
            case 1: return inventar.ID_Produs;
            case 2: return inventar.Cantitate;
        }
        return null;
    }

    public void add(InventarCamera inventar) {
        int index = inventarCamere.size();
        inventarCamere.add(inventar);
        fireTableRowsInserted(index, index);
    }

    public InventarCamera cardAt(int rowIndex) {
        return inventarCamere.get(rowIndex);
    }
}
