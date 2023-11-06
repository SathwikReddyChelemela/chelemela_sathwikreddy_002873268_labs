/*
 * CreateProductJPanel.java
 *
 * Created on September 18, 2008, 2:54 PM
 */
package ui.supplier;

import model.Product;
import model.Supplier;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Sathwik
 */
public class SearchForProductJPanel extends javax.swing.JPanel {

   JPanel workArea;
   Supplier supplier;
   Product product;
    
    /** Creates new form CreateProductJPanel */
    public SearchForProductJPanel(JPanel workArea, Supplier supplier) {
      
        initComponents();
        this.workArea = workArea;
        this.supplier = supplier;
        
        refreshTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblProductId = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Search for Product");

        lblProductId.setText("Product Id:");

        searchButton.setText("Search Now >>");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        btnback.setText("<< Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Product ID", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductId)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnback)
                                .addGap(37, 37, 37)
                                .addComponent(lblTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(searchButton)
                                .addGap(45, 45, 45)
                                .addComponent(btnClear))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback)
                    .addComponent(lblTitle))
                .addGap(61, 61, 61)
                .addComponent(lblProductId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(btnClear))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {searchButton, txtSearch});

    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
       String searchTerm = txtSearch.getText().trim();
       DefaultTableModel searchTableModel = (DefaultTableModel) tblProducts.getModel();
       searchTableModel.setRowCount(0); 
       
       for (Product p : supplier.getProductCatalog().getProductCatalog()) {
           String idString = String.valueOf(p.getId());
           if (idString.contains(searchTerm)) {
                Object row[] = new Object[3];
                row[0] = p;
                row[1] = p.getId();
                row[2] = p.getPrice();
                searchTableModel.addRow(row);
           }
       }
        
}//GEN-LAST:event_searchButtonActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout)workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        
        refreshTable();
    }//GEN-LAST:event_btnClearActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnback;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProductId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        model.setRowCount(0);
    
        for(Product p : supplier.getProductCatalog().getProductCatalog()){
            Object row[] = new Object[3];
            row[0] = p;
            row[1] = p.getId();
            row[2] = p.getPrice();
            model.addRow(row);
           }
        }
}