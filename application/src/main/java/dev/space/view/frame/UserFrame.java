package dev.space.view.frame;

import dev.space.view.dialog.PrintArticleDialog;
import dev.space.view.panel.EditArticlePanel;
import dev.space.view.panel.ManageCategoriesPanel;
import dev.space.view.panel.ManageJournalistsPanel;
import dev.space.view.panel.ViewArticlePanel;
import java.awt.CardLayout;

/**
 *
 * @author tomislav
 */
public class UserFrame extends javax.swing.JFrame {

    private CardLayout layout;

    /**
     * Creates new form UserFrame
     */
    public UserFrame() {
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

        pnlMain = new javax.swing.JPanel();
        mbMain = new javax.swing.JMenuBar();
        mArticle = new javax.swing.JMenu();
        miView = new javax.swing.JMenuItem();
        miEdit = new javax.swing.JMenuItem();
        mManage = new javax.swing.JMenu();
        miCategories = new javax.swing.JMenuItem();
        miJournalists = new javax.swing.JMenuItem();
        mTools = new javax.swing.JMenu();
        miPrint = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Space.dev");
        setMinimumSize(new java.awt.Dimension(1280, 720));

        pnlMain.setLayout(new java.awt.CardLayout());

        mArticle.setMnemonic('N');
        mArticle.setText("Article");

        miView.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miView.setText("View Articles");
        miView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewActionPerformed(evt);
            }
        });
        mArticle.add(miView);

        miEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miEdit.setText("Edit Articles");
        miEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditActionPerformed(evt);
            }
        });
        mArticle.add(miEdit);

        mbMain.add(mArticle);

        mManage.setText("Manage");

        miCategories.setText("Manage Categories");
        miCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriesActionPerformed(evt);
            }
        });
        mManage.add(miCategories);

        miJournalists.setText("Manage Journalists");
        miJournalists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJournalistsActionPerformed(evt);
            }
        });
        mManage.add(miJournalists);

        mbMain.add(mManage);

        mTools.setMnemonic('T');
        mTools.setText("Tools");

        miPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miPrint.setText("Print");
        miPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPrintActionPerformed(evt);
            }
        });
        mTools.add(miPrint);

        mbMain.add(mTools);

        mExit.setMnemonic('E');
        mExit.setText("Exit");

        miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mExit.add(miExit);

        mbMain.add(mExit);

        setJMenuBar(mbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        dispose();
    }//GEN-LAST:event_miExitActionPerformed

    private void miViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewActionPerformed
        layout = (CardLayout) pnlMain.getLayout();
        layout.show(pnlMain, "ViewArticle");
    }//GEN-LAST:event_miViewActionPerformed

    private void miEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditActionPerformed
        layout = (CardLayout) pnlMain.getLayout();
        layout.show(pnlMain, "EditArticle");
    }//GEN-LAST:event_miEditActionPerformed

    private void miPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPrintActionPerformed
        new PrintArticleDialog(this, true).setVisible(true);
    }//GEN-LAST:event_miPrintActionPerformed

    private void miCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriesActionPerformed
        layout = (CardLayout) pnlMain.getLayout();
        layout.show(pnlMain, "ManageCategories");
    }//GEN-LAST:event_miCategoriesActionPerformed

    private void miJournalistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJournalistsActionPerformed
        layout = (CardLayout) pnlMain.getLayout();
        layout.show(pnlMain, "ManageJournalists");
    }//GEN-LAST:event_miJournalistsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu mArticle;
    private javax.swing.JMenu mExit;
    private javax.swing.JMenu mManage;
    private javax.swing.JMenu mTools;
    private javax.swing.JMenuBar mbMain;
    private javax.swing.JMenuItem miCategories;
    private javax.swing.JMenuItem miEdit;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miJournalists;
    private javax.swing.JMenuItem miPrint;
    private javax.swing.JMenuItem miView;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

    private void initialize() {
        initPanels();
    }

    private void initPanels() {
        pnlMain.add(new EditArticlePanel(), "EditArticle");
        pnlMain.add(new ViewArticlePanel(), "ViewArticle");
        pnlMain.add(new ManageCategoriesPanel(), "ManageCategories");
        pnlMain.add(new ManageJournalistsPanel(), "ManageJournalists");

        // display primary panel
        CardLayout layout = (CardLayout) pnlMain.getLayout();
        layout.show(pnlMain, "ViewArticle");
    }
}
