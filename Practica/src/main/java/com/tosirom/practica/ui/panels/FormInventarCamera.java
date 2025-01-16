package com.tosirom.practica.ui.panels;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormInventarCamera extends JPanel {
    private JTable table;
    private JTextField txtIDCamera;
    private JTextField txtIDProdus;
    private JTextField txtCantitate;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnReset;

    private DefaultTableModel tableModel;

    public FormInventarCamera() {
        initComponents();
    }

    private void initComponents() {
        // Labels
        JLabel lblIDCamera = new JLabel("ID Camera:");
        JLabel lblIDProdus = new JLabel("ID Produs:");
        JLabel lblCantitate = new JLabel("Cantitate:");

        // Text fields
        txtIDCamera = new JTextField(10);
        txtIDProdus = new JTextField(10);
        txtCantitate = new JTextField(10);

        // Buttons
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnReset = new JButton("Reset");

        // Table
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID Camera", "ID Produs", "Cantitate"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblIDCamera)
                                        .addComponent(lblIDProdus)
                                        .addComponent(lblCantitate))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIDCamera)
                                        .addComponent(txtIDProdus)
                                        .addComponent(txtCantitate)))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addComponent(btnUpdate)
                                .addComponent(btnDelete)
                                .addComponent(btnReset))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblIDCamera)
                                .addComponent(txtIDCamera))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblIDProdus)
                                .addComponent(txtIDProdus))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCantitate)
                                .addComponent(txtCantitate))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd)
                                .addComponent(btnUpdate)
                                .addComponent(btnDelete)
                                .addComponent(btnReset))
        );

        // Button Actions
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEntry();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEntry();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEntry();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    // Add a new entry to the table
    private void addEntry() {
        try {
            int idCamera = Integer.parseInt(txtIDCamera.getText());
            int idProdus = Integer.parseInt(txtIDProdus.getText());
            int cantitate = Integer.parseInt(txtCantitate.getText());

            tableModel.addRow(new Object[]{idCamera, idProdus, cantitate});
            resetFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Update the selected entry in the table
    private void updateEntry() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int idCamera = Integer.parseInt(txtIDCamera.getText());
                int idProdus = Integer.parseInt(txtIDProdus.getText());
                int cantitate = Integer.parseInt(txtCantitate.getText());

                tableModel.setValueAt(idCamera, selectedRow, 0);
                tableModel.setValueAt(idProdus, selectedRow, 1);
                tableModel.setValueAt(cantitate, selectedRow, 2);
                resetFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Delete the selected entry from the table
    private void deleteEntry() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Reset input fields
    private void resetFields() {
        txtIDCamera.setText("");
        txtIDProdus.setText("");
        txtCantitate.setText("");
    }

    // Main method for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventar Camera");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new FormInventarCamera());
        frame.setVisible(true);
    }
}
