package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creates the panel allowing for filtering of combinations
public class FilterPanel extends JPanel {
    private int filterColumn;
    private JPanel filterButtons;
    private JPanel filterTextBox;
    private JTextField filterText;
    private TableRowSorter<CombinationTableModel> rowSorter;

    // EFFECTS: constructs the filter panel
    public FilterPanel(TableRowSorter<CombinationTableModel> rowSorter) {
        super(new GridLayout(1, 2, 3, 3));
        this.rowSorter = rowSorter;

        initializeFilterButtons();
        initializeFilterTextEntry();

        add(filterButtons);
        add(filterTextBox);
    }

    // EFFECTS: intializes the buttons on the panel
    private void initializeFilterButtons() {
        filterButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
        ButtonGroup filterButtonGroup = new ButtonGroup();

        JRadioButton usernameButton = new JRadioButton("Username");
        JRadioButton passwordButton = new JRadioButton("Password");
        JRadioButton websiteButton = new JRadioButton("Website");

        usernameButton.setSelected(true);

        usernameButton.addActionListener(new UsernameButtonHandler());
        passwordButton.addActionListener(new PasswordButtonHandler());
        websiteButton.addActionListener(new WebsiteButtonHandler());

        filterButtons.add(usernameButton);
        filterButtons.add(passwordButton);
        filterButtons.add(websiteButton);

        filterButtonGroup.add(usernameButton);
        filterButtonGroup.add(passwordButton);
        filterButtonGroup.add(websiteButton);
    }

    // EFFECTS: initializes the textbox for the filter panel
    private void initializeFilterTextEntry() {
        filterTextBox = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 3));

        filterText = new JTextField(20);

        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        createFilter(filterText.getText());
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        createFilter(filterText.getText());
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        createFilter(filterText.getText());

                    }
                }
        );

        filterTextBox.add(new JLabel("Search term:", SwingConstants.TRAILING));
        filterTextBox.add(filterText);
    }

    // EFFECTS: creates the filter to be applied to the table
    private void createFilter(String text) {
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter(text, filterColumn));
        }
    }

    // handles the username button events
    private class UsernameButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filterColumn = 0;
            createFilter(filterText.getText());
        }
    }

    // handles the password button events
    private class PasswordButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filterColumn = 1;
            createFilter(filterText.getText());
        }
    }

    // handles the website button events
    private class WebsiteButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filterColumn = 2;
            createFilter(filterText.getText());
        }
    }
}

