package ui;

import javax.swing.*;
import java.awt.event.KeyEvent;


// creates the edit menu for the menu bar
public class EditMenu extends JMenu {

    // EFFECTS: constructs the edit menu
    public EditMenu(JTable combinationTable) {
        super("Edit");
        setMnemonic(KeyEvent.VK_E);

        AddCombinationItem addCombinationItem = new AddCombinationItem();
        RemoveCombinationItem removeCombinationItem = new RemoveCombinationItem(combinationTable);

        add(addCombinationItem);
        add(removeCombinationItem);
    }
}
