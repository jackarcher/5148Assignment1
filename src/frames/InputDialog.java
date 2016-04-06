/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Archer
 */
public class InputDialog extends javax.swing.JDialog {

    DefaultTableModel defaultTableModel;

    /**
     * Creates new form InputDialog
     */
    public InputDialog(java.awt.Frame parent, String title, Object[] headers) {
        super(parent, title);
        defaultTableModel = new DefaultTableModel(headers, 1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        initComponents();

    }

    public InputDialog(java.awt.Frame parent, String title, Object[] headers, int PK_Number, Object[][] datas) {
        super(parent, title);
        defaultTableModel = new DefaultTableModel(datas, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= PK_Number;
//                return true;
            }
        };
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrContent = new javax.swing.JScrollPane();
        tblContent = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();

        tblContent.setModel(defaultTableModel);
        tblContent.getTableHeader().setReorderingAllowed(false);
        scrContent.setViewportView(tblContent);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrContent, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSubmit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrContent, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        TableCellEditor tableCellEditor = tblContent.getCellEditor();
        if (tableCellEditor != null) {
            tableCellEditor.stopCellEditing();
        }
        dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    public String[] getValues() {
        int columnNumber = tblContent.getColumnCount();
        System.out.println(columnNumber);
        String[] result = new String[columnNumber];
        for (int i = 0; i < columnNumber; i++) {
            result[i] = (String) tblContent.getModel().getValueAt(0, i);
        }
        return result;
    }

    public String[][] getUpdatedData() {
        String[][] updatedData = new String[tblContent.getRowCount()][tblContent.getColumnCount()];
        for (int i = 0; i < updatedData.length; i++) {
            for (int j = 0; j < updatedData[0].length; j++) {
                updatedData[i][j] = tblContent.getModel().getValueAt(i, j).toString();
            }
        }
        return updatedData;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane scrContent;
    private javax.swing.JTable tblContent;
    // End of variables declaration//GEN-END:variables
}
