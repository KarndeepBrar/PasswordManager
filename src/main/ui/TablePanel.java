package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

// creates the panel which displays the combination list in a table
public class TablePanel extends JPanel {

    // constructs the table panel
    public TablePanel(JTable combinationTable, TableRowSorter<CombinationTableModel> rowSorter) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        combinationTable.setRowSorter(rowSorter);

        JScrollPane tableScrollPane = new JScrollPane(combinationTable);
        tableScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        add(tableScrollPane);
    }
}
