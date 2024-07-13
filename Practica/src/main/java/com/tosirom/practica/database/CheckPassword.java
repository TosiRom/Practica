package com.tosirom.practica.database;

import com.tosirom.practica.database.Angajati;
import javax.swing.JTextField;

public class CheckPassword {

    /**
     * Method to verify if the entered password matches the password of the user with the given ID.
     *
     * @param parolaField The JTextField containing the entered password.
     * @param userId The ID of the user to be checked.
     * @return true if the passwords match, false otherwise.
     */
    public static boolean isPasswordCorrect(JTextField parolaField, Integer userId) {
        // Get the entered password
        String enteredPassword = parolaField.getText();
        
        // Fetch the user from the database
        Angajati user = Angajati.GetAngajatiById(userId);
        
        // Check if the entered password matches the user's password
        return enteredPassword.equals(user.Parola);
    }
}
