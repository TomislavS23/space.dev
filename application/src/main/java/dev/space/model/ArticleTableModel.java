package dev.space.model;

import java.util.List;

/**
 *
 * @author Tomislav
 */
public class ArticleTableModel1 extends javax.swing.table.AbstractTableModel{
    
    private static final String[] COLUMN_NAMES = {"Id", "Title", "Link", "Published date", "Picture Path"};
    
    private List<Article> articles;

    public ArticleTableModel1(List<Article> articles) {
        this.articles = articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return articles.size();
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
                return articles.get(rowIndex).getIdArticle();
            case 1:
                return articles.get(rowIndex).getTitle();
            case 2:
                return articles.get(rowIndex).getLink();
            case 3:
                return articles.get(rowIndex).getDatePublished();
            case 4:
                return articles.get(rowIndex).getPicturePath();
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