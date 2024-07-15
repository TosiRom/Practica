package com.tosirom.practica.models;
import com.tosirom.practica.database.Inventar;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InventarTableModel extends AbstractTableModel {
    private List<Inventar> inventar;
    private final String[] columnNames = {"Nume", "Cantitate", "Pret"};

    public InventarTableModel(List<Inventar> inventar) {
        this.inventar = inventar;
    }

    @Override
    public int getRowCount() {
        return inventar.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventar item = inventar.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getNume();
            case 1:
                return item.getCantitate();
            case 2:
                return item.getPret();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}