package com.tosirom.practica.ui.panels;

import com.tosirom.practica.database.Database;
import com.tosirom.practica.database.Plati;
import com.tosirom.practica.models.PlatiTableModel;
import java.sql.Date;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;

/**
 * FormPlati Panel
 */
public class FormPlati extends javax.swing.JPanel {

    /**
     * Creates new form FormPlati
     */
    public FormPlati() {
        initComponents();
        RefreshPlatiTable();

        // Enable sorting on the table
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabelPlati.getModel());
        tabelPlati.setRowSorter(sorter);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelPlati = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSuma = new javax.swing.JTextField();
        cmbMetoda = new javax.swing.JComboBox<>();
        datePlata = new com.toedter.calendar.JDateChooser();
        cmbInchirieri = new javax.swing.JComboBox<>();
        btnChange = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(evt -> RefreshPlatiTable());

        btnDelete.setText("Delete selected row");
        btnDelete.addActionListener(evt -> deleteSelectedRow());

        tabelPlati.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Suma", "Metoda", "Data", "ID Inchiriere"}
        ));
        jScrollPane5.setViewportView(tabelPlati);

        jLabel1.setText("Suma:");
        jLabel2.setText("Metoda:");
        jLabel3.setText("Data:");
        jLabel4.setText("ID Inchiriere:");

        cmbMetoda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Cash", "Card", "Transfer"}));

        btnChange.setText("Creeaza / Actualizeaza");
        btnChange.addActionListener(evt -> saveOrUpdatePlati());

        btnReset.setText("Reset");
        btnReset.addActionListener(evt -> resetForm());

        // Layout Configuration
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cmbMetoda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(datePlata, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cmbInchirieri, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRefresh)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnReset)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnChange)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(datePlata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(cmbMetoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(cmbInchirieri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRefresh)
                                        .addComponent(btnDelete)
                                        .addComponent(btnReset)
                                        .addComponent(btnChange))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void resetForm() {
        txtSuma.setText("");
        cmbMetoda.setSelectedIndex(0);
        datePlata.setDate(new Date(System.currentTimeMillis()));
        cmbInchirieri.setSelectedIndex(0);
    }

    private void populateDropdowns() {
        try (var conn = Database.getConnection()) {
            String SQL = "SELECT ID FROM Inchirieri";
            var statement = conn.createStatement();
            var result = statement.executeQuery(SQL);

            cmbInchirieri.removeAllItems();
            while (result.next()) {
                Integer id = result.getInt("ID");
                cmbInchirieri.addItem(id.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error populating the combo box: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void RefreshPlatiTable() {
        populateDropdowns();
        PlatiTableModel model = new PlatiTableModel();
        tabelPlati.setModel(model);

        try {
            var plati = Plati.GetAllPlati();
            for (var p : plati) {
                model.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error refreshing the table: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedRow() {
        PlatiTableModel model = (PlatiTableModel) tabelPlati.getModel();
        int[] selRows = tabelPlati.getSelectedRows();

        for (int i = 0; i < selRows.length; i++) {
            Plati.DeletePlati((Integer) model.getValueAt(selRows[i], 0));
        }

        RefreshPlatiTable();
    }

    private void saveOrUpdatePlati() {
        try {
            Plati p = new Plati();
            p.Suma = Double.parseDouble(txtSuma.getText());

            if (p.Suma <= 0) {
                JOptionPane.showMessageDialog(this, "Suma must be greater than 0.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            p.Metoda = (String) cmbMetoda.getSelectedItem();
            p.Data = new Date(datePlata.getDate().getTime());

            // Ensure that date is valid
            if (p.Data == null) {
                JOptionPane.showMessageDialog(this, "Please select a valid date.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            p.Id_Inchiriere = Integer.parseInt((String) cmbInchirieri.getSelectedItem());

            boolean success = Plati.CreatePlati(p);
            if (success) {
                resetForm();
                RefreshPlatiTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save or update the payment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving the payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbMetoda;
    private javax.swing.JComboBox<String> cmbInchirieri;
    private com.toedter.calendar.JDateChooser datePlata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabelPlati;
    private javax.swing.JTextField txtSuma;
    // End of variables declaration
}
