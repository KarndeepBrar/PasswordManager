package ui;

import exception.PasswordLengthException;
import exception.UsernameLengthException;
import model.Combination;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.PasswordManager.updateTable;

// Creates the add combination menu item
public class AddCombinationItem extends JMenuItem implements ActionListener {
    JTextField usernameField;
    JTextField passwordField;
    JTextField websiteField;

    // EFFECTS: creates the add combination item
    public AddCombinationItem() {
        super("Add");
        addActionListener(this);
    }

    // EFFECTS: displays an add combination pop up box and adds the combination if username & password length > 0
    // otherwise displays pop up again
    // MODIFIES: PasswordManager
    private void addCombination(String requirementText) {
        JPanel comboPopUp = createAddComboPopUp(requirementText);

        int result = JOptionPane.showConfirmDialog(this, comboPopUp,
                "Please Enter Account Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                PasswordManager.comboList.addCombination(new Combination(usernameField.getText(),
                        passwordField.getText(),
                        websiteField.getText()));
            } catch (UsernameLengthException ex) {
                addCombination("Username was not entered.");
            } catch (PasswordLengthException ex) {
                addCombination("Password was not entered.");
            }
        }
    }

    // EFFECTS: creates the pop-up for the action
    private JPanel createAddComboPopUp(String requirementText) {
        JPanel comboPopUp = new JPanel();

        usernameField = new JTextField(10);
        passwordField = new JTextField(10);
        websiteField = new JTextField(10);

        comboPopUp.add(new JLabel("Username*:"));
        comboPopUp.add(usernameField);
        comboPopUp.add(Box.createHorizontalStrut(20));
        comboPopUp.add(new JLabel("Password*:"));
        comboPopUp.add(passwordField);
        comboPopUp.add(Box.createHorizontalStrut(20));
        comboPopUp.add(new JLabel("Website:"));
        comboPopUp.add(websiteField);
        comboPopUp.add(Box.createVerticalStrut(20));
        comboPopUp.add(new JLabel(requirementText));

        return comboPopUp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addCombination("* indicated required field.");
        updateTable();
    }
}
