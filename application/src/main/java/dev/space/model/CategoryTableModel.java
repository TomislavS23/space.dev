package dev.space.model;

import java.util.List;

/**
 *
 * @author Tomislav
 */
public class CategoryTableModel extends javax.swing.table.AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Id", "Category Type"};

    private List<Category> categories;

    public CategoryTableModel(List<Category> articles) {
        this.categories = articles;
    }

    public void setCategories(List<Category> articles) {
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
                return categories.get(rowIndex).getIdCategory();
            case 1:
                return categories.get(rowIndex).getCategoryType();
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
