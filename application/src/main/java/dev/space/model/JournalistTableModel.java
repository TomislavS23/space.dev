package dev.space.model;

import java.util.List;

/**
 *
 * @author Tomislav
 */
public class JournalistTableModel extends javax.swing.table.AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Id", "First Name", "Last Name"};

    private List<Journalist> categories;

    public JournalistTableModel(List<Journalist> articles) {
        this.categories = articles;
    }

    public void setJournalists(List<Journalist> articles) {
        this.categories = articles;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        //return Article.class.getDeclaredFields().length - 1;
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return categories.get(rowIndex).getIdJournalist();
            case 1:
                return categories.get(rowIndex).getFirstName();
            case 2:
                return categories.get(rowIndex).getLastName();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    // important for the id ordering
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }

}
