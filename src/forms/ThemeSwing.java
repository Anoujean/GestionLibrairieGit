/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.*;
import data.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author anouj
 */
public class ThemeSwing extends javax.swing.JFrame {

    /**
     * Creates new form Theme
     */
    private Librairie lib = new Librairie();

    public ThemeSwing() {
        lib.load();
        Collections.sort(lib.getLesSous_themes());
        initComponents();
        this.pnl_cb_theme.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_auteur_rechercher1 = new javax.swing.JPanel();
        tf_themes_recherche = new javax.swing.JTextField();
        btn_theme_recherche = new javax.swing.JButton();
        lbl_theme_rechercher = new javax.swing.JLabel();
        rb_sous_theme = new javax.swing.JRadioButton();
        rb_theme = new javax.swing.JRadioButton();
        pnl_info_theme = new javax.swing.JPanel();
        lbl_theme_id_libelle = new javax.swing.JLabel();
        lbl_theme_id = new javax.swing.JLabel();
        lbl_libelle_theme_libelle = new javax.swing.JLabel();
        tf_theme_libelle = new javax.swing.JTextField();
        pnl_cb_theme = new javax.swing.JPanel();
        lbl_cb_theme = new javax.swing.JLabel();
        cb_theme = new javax.swing.JComboBox();
        btn_theme_ajouter = new javax.swing.JButton();
        btn_theme_modifier = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree_theme = new javax.swing.JTree();
        btn_theme_afficher = new javax.swing.JButton();
        btn_theme_vider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_auteur_rechercher1.setBackground(new java.awt.Color(204, 255, 255));

        btn_theme_recherche.setText("ok");
        btn_theme_recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theme_rechercheActionPerformed(evt);
            }
        });

        lbl_theme_rechercher.setText("Rechercher");

        javax.swing.GroupLayout pnl_auteur_rechercher1Layout = new javax.swing.GroupLayout(pnl_auteur_rechercher1);
        pnl_auteur_rechercher1.setLayout(pnl_auteur_rechercher1Layout);
        pnl_auteur_rechercher1Layout.setHorizontalGroup(
            pnl_auteur_rechercher1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_auteur_rechercher1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_theme_rechercher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_themes_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_theme_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        pnl_auteur_rechercher1Layout.setVerticalGroup(
            pnl_auteur_rechercher1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_auteur_rechercher1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_auteur_rechercher1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_theme_rechercher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_theme_recherche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_themes_recherche, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        rb_sous_theme.setText("Sous-thème");
        rb_sous_theme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb_sous_themeItemStateChanged(evt);
            }
        });

        rb_theme.setText("Thème");
        rb_theme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb_themeItemStateChanged(evt);
            }
        });

        pnl_info_theme.setBackground(new java.awt.Color(204, 255, 255));

        lbl_theme_id_libelle.setText("Identifiant :");

        lbl_theme_id.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        lbl_theme_id.setForeground(new java.awt.Color(0, 102, 51));

        lbl_libelle_theme_libelle.setText("Libellé");

        javax.swing.GroupLayout pnl_info_themeLayout = new javax.swing.GroupLayout(pnl_info_theme);
        pnl_info_theme.setLayout(pnl_info_themeLayout);
        pnl_info_themeLayout.setHorizontalGroup(
            pnl_info_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_info_themeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnl_info_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_libelle_theme_libelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_theme_id_libelle, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_info_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_theme_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_theme_libelle))
                .addContainerGap())
        );
        pnl_info_themeLayout.setVerticalGroup(
            pnl_info_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_info_themeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl_info_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_theme_id_libelle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_theme_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_info_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_libelle_theme_libelle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_theme_libelle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pnl_cb_theme.setBackground(new java.awt.Color(204, 255, 255));

        lbl_cb_theme.setText("Son Thème");

        cb_theme.setModel(initThemeModelComboBox());

        javax.swing.GroupLayout pnl_cb_themeLayout = new javax.swing.GroupLayout(pnl_cb_theme);
        pnl_cb_theme.setLayout(pnl_cb_themeLayout);
        pnl_cb_themeLayout.setHorizontalGroup(
            pnl_cb_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cb_themeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cb_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cb_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_cb_themeLayout.setVerticalGroup(
            pnl_cb_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cb_themeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cb_themeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cb_theme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_theme, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_theme_ajouter.setBackground(new java.awt.Color(153, 255, 153));
        btn_theme_ajouter.setText("Ajouter");
        btn_theme_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theme_ajouterActionPerformed(evt);
            }
        });

        btn_theme_modifier.setBackground(new java.awt.Color(255, 255, 153));
        btn_theme_modifier.setText("Modifier");
        btn_theme_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theme_modifierActionPerformed(evt);
            }
        });

        jTree_theme.setModel(initThemesTreeModel());
        jScrollPane2.setViewportView(jTree_theme);

        btn_theme_afficher.setBackground(new java.awt.Color(153, 204, 255));
        btn_theme_afficher.setText("Afficher");
        btn_theme_afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theme_afficherActionPerformed(evt);
            }
        });

        btn_theme_vider.setText("Vider");
        btn_theme_vider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theme_viderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(rb_theme)
                                .addGap(162, 162, 162)
                                .addComponent(rb_sous_theme))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(pnl_auteur_rechercher1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnl_info_theme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnl_cb_theme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btn_theme_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(btn_theme_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_theme_vider, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_theme_afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_auteur_rechercher1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_theme)
                            .addComponent(rb_sous_theme))
                        .addGap(33, 33, 33)
                        .addComponent(pnl_info_theme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl_cb_theme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_theme_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_theme_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_theme_vider, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_theme_afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(645, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private DefaultComboBoxModel initThemeModelComboBox() {
        return new DefaultComboBoxModel(initThemeVector());
    }

    private Vector initThemeVector() {
        Vector v = new Vector();
        for (Theme leTheme : this.lib.getLesThemes()) {
            v.add(leTheme);
        }
        Collections.sort(v);
        return v;
    }

    private DefaultTreeModel initThemesTreeModel() {
        return new DefaultTreeModel(initThemesTree());
    }

    private DefaultMutableTreeNode initThemesTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Mes Themes");

        DefaultMutableTreeNode tnTheme = null;
        DefaultMutableTreeNode tnSousTheme = null;

        Collections.sort(this.lib.getLesThemes());
        for (Theme unTheme : this.lib.getLesThemes()) {
            tnTheme = new DefaultMutableTreeNode(unTheme);
            root.add(tnTheme);
            List<Sous_theme> sesSousThemes = unTheme.getLeSous_themes();
            if (sesSousThemes != null) {
                Collections.sort(sesSousThemes);
                for (Sous_theme unSousTheme : sesSousThemes) {
                    tnTheme.add(tnSousTheme = new DefaultMutableTreeNode(unSousTheme));
                }
            }
        }
        System.out.println("Done!");

        return root;
    }

    private void rb_themeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb_themeItemStateChanged
        // TODO add your handling code here:
        this.pnl_cb_theme.setVisible(false);
    }//GEN-LAST:event_rb_themeItemStateChanged

    private void rb_sous_themeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb_sous_themeItemStateChanged
        // TODO add your handling code here:
        this.pnl_cb_theme.setVisible(true);
    }//GEN-LAST:event_rb_sous_themeItemStateChanged

    private void btn_theme_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theme_ajouterActionPerformed
        // TODO add your handling code here:
        if (this.rb_sous_theme.isSelected()) {
            Sous_theme unSousTheme = new Sous_theme(this.tf_theme_libelle.getText(), ((Theme) this.cb_theme.getSelectedItem()));
            lib.AjouterSous_theme(unSousTheme);
        } else {
            Theme unTheme = new Theme(this.tf_theme_libelle.getText());
            lib.AjouterTheme(unTheme);
        }
        this.lib.load();
        resetFieldsTheme();
        jTree_theme.setModel(this.initThemesTreeModel());
        cb_theme.setModel(this.initThemeModelComboBox());
    }//GEN-LAST:event_btn_theme_ajouterActionPerformed

    private void btn_theme_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theme_modifierActionPerformed
        // TODO add your handling code here:
        if (this.rb_sous_theme.isSelected()) {
            Sous_theme unSousTheme = new Sous_theme(Integer.valueOf(this.lbl_theme_id.getText()), ((Theme) this.cb_theme.getSelectedItem()), this.tf_theme_libelle.getText());
            lib.modifierSous_theme(unSousTheme);
        } else {
            Theme unTheme = new Theme(this.tf_theme_libelle.getText());
            lib.modifierTheme(unTheme);
        }
        this.lib.load();
        resetFieldsTheme();
        jTree_theme.setModel(this.initThemesTreeModel());
        cb_theme.setModel(this.initThemeModelComboBox());
    }//GEN-LAST:event_btn_theme_modifierActionPerformed

    private void btn_theme_afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theme_afficherActionPerformed
        // TODO add your handling code here:
        if (jTree_theme.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vous devez selectionner un theme ou un sous-theme!");
        } else {
            DefaultMutableTreeNode tn = (DefaultMutableTreeNode) jTree_theme.getLastSelectedPathComponent();
            if (tn.getUserObject() instanceof Sous_theme) {
                Sous_theme a = (Sous_theme) tn.getUserObject();
                this.rb_sous_theme.setSelected(true);
                this.lbl_theme_id.setText("" + a.getId_sous_theme());
                this.tf_theme_libelle.setText(a.getLibelle());
                this.cb_theme.setSelectedItem(a.getTheme());
            } else if (tn.getUserObject() instanceof Theme) {
                Theme a = (Theme) tn.getUserObject();
                this.rb_theme.setSelected(true);
                this.lbl_theme_id.setText("" + a.getId_theme());
                this.tf_theme_libelle.setText(a.getLibelle());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vous devez selectionner un theme ou un sous-theme!");
            }
        }
    }//GEN-LAST:event_btn_theme_afficherActionPerformed

    private void btn_theme_rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theme_rechercheActionPerformed
        // TODO add your handling code here:
        this.lib.loadTheme(this.tf_themes_recherche.getText());
        jTree_theme.setModel(this.initThemesTreeModel());
        this.resetFieldsTheme();
    }//GEN-LAST:event_btn_theme_rechercheActionPerformed

    private void btn_theme_viderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theme_viderActionPerformed
        // TODO add your handling code here:
        resetFieldsTheme();
    }//GEN-LAST:event_btn_theme_viderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemeSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemeSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemeSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemeSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemeSwing().setVisible(true);
            }
        });
    }

    public void resetFieldsTheme() {
        this.rb_theme.setSelected(false);
        this.rb_sous_theme.setSelected(false);
        this.lbl_theme_id.setText("");
        this.tf_theme_libelle.setText("");
        this.pnl_cb_theme.setVisible(false);
        this.tf_themes_recherche.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_theme_afficher;
    private javax.swing.JButton btn_theme_ajouter;
    private javax.swing.JButton btn_theme_modifier;
    private javax.swing.JButton btn_theme_recherche;
    private javax.swing.JButton btn_theme_vider;
    private javax.swing.JComboBox cb_theme;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree_theme;
    private javax.swing.JLabel lbl_cb_theme;
    private javax.swing.JLabel lbl_libelle_theme_libelle;
    private javax.swing.JLabel lbl_theme_id;
    private javax.swing.JLabel lbl_theme_id_libelle;
    private javax.swing.JLabel lbl_theme_rechercher;
    private javax.swing.JPanel pnl_auteur_rechercher1;
    private javax.swing.JPanel pnl_cb_theme;
    private javax.swing.JPanel pnl_info_theme;
    private javax.swing.JRadioButton rb_sous_theme;
    private javax.swing.JRadioButton rb_theme;
    private javax.swing.JTextField tf_theme_libelle;
    private javax.swing.JTextField tf_themes_recherche;
    // End of variables declaration//GEN-END:variables
}
