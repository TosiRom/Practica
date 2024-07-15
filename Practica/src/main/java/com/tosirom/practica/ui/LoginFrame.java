
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tosirom.practica.ui;

/**
 *
 *
 */
import com.tosirom.practica.database.Angajati;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

    private PassWordDialog passDialog;

    public LoginFrame() {
        passDialog = new PassWordDialog(this, true);
        passDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new LoginFrame();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setTitle("Logged In");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}

class PassWordDialog extends JDialog {

    private final JLabel jlblUsername = new JLabel("Username");
    private final JLabel jlblPassword = new JLabel("Password");

    private final JTextField jtfUsername = new JTextField(15);
    private final JPasswordField jpfPassword = new JPasswordField();

    private final JButton jbtOk = new JButton("Login");
    private final JButton jbtCancel = new JButton("Cancel");

    private final JLabel jlblStatus = new JLabel(" ");

    public PassWordDialog() {
        this(null, true);
    }

    public PassWordDialog(final JFrame parent, boolean modal) {
        super(parent, modal);
        
        this.setTitle("Login");

        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(jlblUsername);
        p3.add(jlblPassword);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });


        jbtOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String user = "stackoverflow";
//                String pass = "stackoverflow";
                //Check username and password
//                boolean canLogin = pass.equals(String.valueOf(jpfPassword.getPassword())) && user.equals(jtfUsername.getText());
                boolean canLogin = Angajati.CheckEmployeeUsernameAndPassword(jtfUsername.getText(), String.valueOf(jpfPassword.getPassword()));
                
                
                if (canLogin) {
                    parent.setVisible(true);
                    setVisible(false);
                } else {
                    jlblStatus.setText("Invalid username or password");
                }
            }
        });
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
                System.exit(0);
            }
        });
    }
}