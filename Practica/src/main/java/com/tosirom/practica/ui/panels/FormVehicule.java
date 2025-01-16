/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tosirom.practica.ui.panels;

import com.tosirom.practica.database.Vehicule;
import com.tosirom.practica.models.VehiculeTableModel;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * A JPanel for managing vehicule entries in the database.
 */
public class FormVehicule extends javax.swing.JPanel {

    /**
     * Creates new form FormVehicule
     */
    public FormVehicule() {
        initComponents();
        refreshVehiculeTable();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabelVehicule.getModel());
        tabelVehicule.setRowSorter(sorter);
    }

    /**
     * This method initializes the GUI components.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnDeleteVehicule = new javax.swing.JButton();
        btnResetVehicule = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelVehicule = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNumarInmatriculare = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIDClient = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarcaModel = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAdaugaVehicul = new javax.swing.JButton();

        btnDeleteVehicule.setText("Delete selected row");
        btnDeleteVehicule.addActionListener(evt -> deleteSelectedVehicule());

        btnResetVehicule.setText("Refresh");
        btnResetVehicule.addActionListener(evt -> refreshVehiculeTable());

        tabelVehicule.setModel(new VehiculeTableModel());
        jScrollPane1.setViewportView(tabelVehicule);

        jLabel1.setText("Numar Inmatriculare");

        jLabel2.setText("ID Client");

        jLabel3.setText("Marca/Model Vehicul");

        btnClear.setText("Reset");
        btnClear.addActionListener(evt -> clearFields());

        btnAdaugaVehicul.setText("Adauga vehicul");
        btnAdaugaVehicul.addActionListener(evt -> addVehicule());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtMarcaModel)
                                                        .addComponent(txtIDClient)
                                                        .addComponent(txtNumarInmatriculare)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnClear)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 450, Short.MAX_VALUE)
                                                .addComponent(btnAdaugaVehicul))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnResetVehicule)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDeleteVehicule)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNumarInmatriculare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtIDClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMarcaModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdaugaVehicul)
                                        .addComponent(btnClear))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnResetVehicule)
                                        .addComponent(btnDeleteVehicule))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );
    }

    /**
     * Deletes the selected vehicule(s) from the table and the database.
     */
    private void deleteSelectedVehicule() {
        VehiculeTableModel model = (VehiculeTableModel) tabelVehicule.getModel();

        int[] selRows = tabelVehicule.getSelectedRows();

        for (int i = selRows.length - 1; i >= 0; i--) {
            int modelRow = tabelVehicule.convertRowIndexToModel(selRows[i]);
            Vehicule.DeleteVehicule((Integer) model.getValueAt(modelRow, 0));
        }

        refreshVehiculeTable();
    }

    /**
     * Refreshes the vehicule table with updated data.
     */
    private void refreshVehiculeTable() {
        tabelVehicule.setModel(new VehiculeTableModel());
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabelVehicule.getModel());
        tabelVehicule.setRowSorter(sorter);
    }

    /**
     * Clears the input fields.
     */
    private void clearFields() {
        txtNumarInmatriculare.setText("");
        txtIDClient.setText("");
        txtMarcaModel.setText("");
    }

    /**
     * Adds a new vehicule to the database and updates the table.
     */
    private void addVehicule() {
        Vehicule vehicul = new Vehicule();

        vehicul.Numar_Inmatriculare = txtNumarInmatriculare.getText();
        vehicul.ID_Client = Integer.parseInt(txtIDClient.getText());
        vehicul.Marca_Model_Vehicul = txtMarcaModel.getText();

        boolean result = Vehicule.CreateVehicule(vehicul);

        if (result) {
            clearFields();
            refreshVehiculeTable();
        } else {
            // Handle failure, possibly showing an error dialog.
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdaugaVehicul;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteVehicule;
    private javax.swing.JButton btnResetVehicule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelVehicule;
    private javax.swing.JTextField txtIDClient;
    private javax.swing.JTextField txtMarcaModel;
    private javax.swing.JTextField txtNumarInmatriculare;
    // End of variables declaration
}
