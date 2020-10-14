package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.PasswordManager.updateTable;

// Class for the remove combination menu item
public class RemoveCombinationItem extends JMenuItem implements ActionListener {
    private JTable combinationTable;

    // EFFECTS: creates the remove combination item
    public RemoveCombinationItem(JTable combinationTable) {
        super("Remove");
        this.combinationTable = combinationTable;
        addActionListener(this);
    }

    // EFFECTS: displays a confirmation window and removes the selected combination if yes is selected
    // MODIFIES: PasswordManager
    private void removeCombination() {
        int option = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to remove this?",
                "Confirm Removal", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            PasswordManager.comboList.removeCombo(combinationTable.getSelectedRow());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        removeCombination();
        updateTable();
    }
}
