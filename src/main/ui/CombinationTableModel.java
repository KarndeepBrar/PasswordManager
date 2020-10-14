package ui;

import model.Combination;
import model.CombinationList;

import javax.swing.table.AbstractTableModel;

// creates the table model
public class CombinationTableModel extends AbstractTableModel {
    private CombinationList comboList;

    // EFFECTS: constructs the combination table model
    public  CombinationTableModel(CombinationList comboList) {
        super();
        this.comboList = comboList;
    }

    public void setComboList(CombinationList comboList) {
        this.comboList = comboList;
    }

    @Override
    public int getRowCount() {
        return comboList.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "Username";
                break;
            case 1:
                name = "Password";
                break;
            case 2:
                name = "Website";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
                type = String.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Combination combo = comboList.getCombo(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = combo.getUsername();
                break;
            case 1:
                value = combo.getPassword();
                break;
            case 2:
                value = combo.getWebsite();
                break;
        }
        return value;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Combination combo = comboList.getCombo(rowIndex);
        switch (columnIndex) {
            case 0:
                combo.setUsername((String)value);
                break;
            case 1:
                combo.setPassword((String)value);
                break;
            case 2:
                combo.setWebsite((String)value);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}

