package ui;

import com.formdev.flatlaf.FlatLightLaf;
import model.CombinationList;
import persistence.Read;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

// creates the ui for the password manager
public class PasswordManager extends JFrame {
    private static CombinationTableModel tableModel;
    public static CombinationList comboList;
    private JTable combinationTable;
    private TableRowSorter<CombinationTableModel> rowSorter;

    // EFFECTS: constructs the password manager
    public PasswordManager() {
        super("Password Manager");
        comboList = initComboList();
        tableModel = new CombinationTableModel(comboList);
        combinationTable = new JTable(tableModel);
        rowSorter = new TableRowSorter<>(tableModel);

        JMenuBar menuBar = createMenuBar();
        JPanel contentPane = createContentPane();

        setJMenuBar(menuBar);
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        pack();
        setVisible(true);
    }

    // EFFECTS: initializes the combination list by trying to load the previous file or creating a new one
    // MODIFIES: this
    private CombinationList initComboList() {
        CombinationList comboList;
        try {
            comboList = Read.readLastFile("lastComboUsed.txt");
        } catch (Exception e) {
            comboList = new CombinationList();
        }
        return comboList;
    }

    // EFFECTS: creates a JMenuBar with an File menu and Edit menu
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        FileMenu fileMenu = new FileMenu();
        EditMenu editMenu = new EditMenu(combinationTable);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        return menuBar;
    }

    // EFFECTS: creates the content pane that is visible to the user
    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        TablePanel tablePanel = new TablePanel(combinationTable, rowSorter);

        JSeparator lineSeparator = new JSeparator();
        lineSeparator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));

        FilterPanel filterPanel = new FilterPanel(rowSorter);
        filterPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10));

        contentPane.add(tablePanel);
        contentPane.add(lineSeparator);
        contentPane.add(filterPanel);

        return contentPane;
    }

    // EFFECTS: updates the table when it is changed
    // MODIFIES: this
    public static void updateTable() {
        tableModel.setComboList(comboList);
        tableModel.fireTableDataChanged();
    }
}
