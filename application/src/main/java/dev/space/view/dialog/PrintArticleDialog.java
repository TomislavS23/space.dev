/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dev.space.view.dialog;

import dev.space.dto.ArticleDTO;
import dev.space.factory.MapperFactory;
import dev.space.model.Article;
import dev.space.model.ArticleTableModel;
import dev.space.query.operation.ArticleOperations;
import dev.space.session.HibernateSessionFactory;
import dev.space.session.Operations;
import dev.space.utilities.JAXBUtils;
import dev.space.utilities.MessageUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import org.modelmapper.ModelMapper;

/**
 *
 * @author tomislav
 */
public class PrintArticleDialog extends javax.swing.JDialog {

    /**
     * Creates new form PrintArticleDialog
     */
    public PrintArticleDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticles = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbArticles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbArticles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArticlesMouseClicked(evt);
            }
        });
        tbArticles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbArticlesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbArticles);

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbArticlesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbArticlesKeyReleased
        try {
            selectArticle();
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Error", ex.getMessage());
        }
    }//GEN-LAST:event_tbArticlesKeyReleased

    private void tbArticlesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArticlesMouseClicked
        try {
            selectArticle();
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Error", ex.getMessage());
        }
    }//GEN-LAST:event_tbArticlesMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (selectedArticle == null) {
            MessageUtils.showErrorMessage("Error", "You must select article form the table before printing.");
            return;
        }
        
        ArticleDTO article = mapper.map(selectedArticle, ArticleDTO.class);
        
        try {
            // JAXBUtils.save(article, FILENAME);
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbArticles;
    // End of variables declaration//GEN-END:variables

    private static final String FILENAME = "src/main/resources/paperarchive.xml";
    
    private ArticleTableModel articlesTableModel;
    private ArticleOperations articleSession;
    private Article selectedArticle;
    private ModelMapper mapper;

    private void initialize() {
        try {
            initSessions();
            initMapper();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(PrintArticleDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initSessions() {
        articleSession = HibernateSessionFactory.InitializeSession(Operations.ARTICLE);
    }

    private void initTable() throws Exception {
        tbArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbArticles.setAutoCreateRowSorter(true);
        tbArticles.setRowHeight(25);
        articlesTableModel = new ArticleTableModel(articleSession.ReadAllEntities());
        tbArticles.setModel(articlesTableModel);
    }

    private void initMapper() {
        mapper = MapperFactory.InitializeMapper();
    }

    private void selectArticle() throws Exception {
        int selectedRow = tbArticles.getSelectedRow();
        int rowIndex = tbArticles.convertRowIndexToModel(selectedRow);

        int id = (int) articlesTableModel.getValueAt(rowIndex, 0);
        selectedArticle = articleSession.ReadEntityById(id);
    }

}
