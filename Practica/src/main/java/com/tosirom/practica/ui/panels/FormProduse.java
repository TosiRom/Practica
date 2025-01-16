package com.tosirom.practica.ui.panels;

import com.tosirom.practica.database.Produse;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormProduse extends javax.swing.JPanel {

    private javax.swing.JButton btnAdaugaProduse;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteProduse;
    private javax.swing.JButton btnResetProduse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelProduse;
    private javax.swing.JTextField txtDenumire;
    private javax.swing.JTextField txtPret;

    public FormProduse() {
        initComponents();
        populateTable();
    }

    private void initComponents() {

        btnDeleteProduse = new javax.swing.JButton();
        btnResetProduse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelProduse = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDenumire = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPret = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAdaugaProduse = new javax.swing.JButton();

        btnDeleteProduse.setText("Delete selected row");
        btnDeleteProduse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProduseActionPerformed(evt);
            }
        });

        btnResetProduse.setText("Refresh");
        btnResetProduse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetProduseActionPerformed(evt);
            }
        });

        tabelProduse.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"ID", "Denumire", "Pret"}
        ));
        jScrollPane1.setViewportView(tabelProduse);

        jLabel1.setText("Denumire");

        jLabel2.setText("Pret");

        btnClear.setText("Reset");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnAdaugaProduse.setText("Adauga produs");
        btnAdaugaProduse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdaugaProduseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnResetProduse)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDeleteProduse)
                                                .addGap(0, 480, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addGap(75, 75, 75)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtPret)
                                                                        .addComponent(txtDenumire)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(btnClear)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnAdaugaProduse)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDenumire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdaugaProduse)
                                        .addComponent(btnClear))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnResetProduse)
                                        .addComponent(btnDeleteProduse))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );
    }

    private void btnDeleteProduseActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tabelProduse.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tabelProduse.getValueAt(selectedRow, 0);
            if (Produse.DeleteProduse(id)) {
                JOptionPane.showMessageDialog(this, "Produs deleted successfully");
                populateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Error deleting produs");
            }
        }
    }

    private void btnResetProduseActionPerformed(java.awt.event.ActionEvent evt) {
        populateTable();
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        txtDenumire.setText("");
        txtPret.setText("");
    }

    private void btnAdaugaProduseActionPerformed(java.awt.event.ActionEvent evt) {
        String denumire = txtDenumire.getText();
        String pretText = txtPret.getText();

        if (!denumire.isEmpty() && !pretText.isEmpty()) {
            try {
                double pret = Double.parseDouble(pretText);
                Produse produs = new Produse(0, denumire, pret);
                if (Produse.CreateProduse(produs)) {
                    JOptionPane.showMessageDialog(this, "Produs added successfully");
                    populateTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Error adding produs");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid price");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
        }
    }

    private void populateTable() {
        List<Produse> produseList = Produse.GetAllProduse();
        DefaultTableModel model = (DefaultTableModel) tabelProduse.getModel();
        model.setRowCount(0);  // Clear existing rows
        for (Produse produs : produseList) {
            model.addRow(new Object[]{produs.ID, produs.Denumire, produs.Pret});
        }
    }
}
