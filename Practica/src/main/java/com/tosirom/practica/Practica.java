/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tosirom.practica;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.tosirom.practica.ui.LoginFrame;

import com.tosirom.practica.ui.MainFrame2;


/**
 *
 */
public class Practica {

    public static void main(String[] args) {

        FlatDarculaLaf.setup();
        
//        LoginFrame lf = new LoginFrame();
//        lf.setVisible(true);
        
        MainFrame2 mf = new MainFrame2();
        
        mf.setVisible(true);
    }
}
