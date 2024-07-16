package com.tosirom.practica.models;
import com.tosirom.practica.database.Inchirieri;
import com.tosirom.practica.database.Inventar;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class InventarTableModel  extends AbstractTableModel {
    protected static String[] COLUMN_NAMES = {"ID", "ID Produs", "Cantitate"};
    protected static Class[] COLUMN_CLASSES = {Integer.class, Integer.class, Integer.class};        
    
    private Set<Integer> selected;
    private List<Inventar> inventar;
    
    public InventarTableModel() {
        selected = new TreeSet<>();
        inventar = new ArrayList<>(25);
    }
    
    @Override
    public int getRowCount() {
        return inventar.size();
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
        Inventar client = inventar.get(rowIndex);
        switch (columnIndex) {
            case 0: return client.ID;
            case 1: return client.ID_Produs;
            case 2: return client.Cantitate;
        }
        return null;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Inventar client = inventar.get(rowIndex);
        switch (columnIndex) {
//            case 0:
//                client.ID;
//                break;
            case 1:
                client.ID_Produs = (int)aValue;
                break;
            case 2:
                client.Cantitate = (int)aValue;
                break;
            
        }
        // Update the database
      
        // Notify listeners that the data has changed
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
      private void updateDatabse(Inventar i) {
        Inventar.UpdateInventar(i);
    }
    
     public void add(Inventar client) {
        int index = inventar.size();
        inventar.add(client);
        fireTableRowsInserted(index, index);
    }

    public Inventar cardAt(int rowIndex) {
        return inventar.get(rowIndex);
    }
    
}
