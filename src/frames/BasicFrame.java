/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Archer
 */
public class BasicFrame extends javax.swing.JFrame implements FundamentalFunctions {

    private final String DATABASE_A = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a";
    private final String DATABASE_B = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148b";
    private final String USERNAME = "S26298090";
    private final String PWD = "student";
    private String hint;
    private final String dbName;
    private final String tableName;
    private final String searchQuery;
    private final int PK_Number;
    private DefaultTableModel defaultTableModel;

    /**
     * Creates new form BasicFrame
     */
    public BasicFrame(String frameTitle) {
        setTitle(frameTitle + " Frame");
        switch (frameTitle.toLowerCase()) {
            case "conference":
                dbName = DATABASE_A;
                tableName = "CONFERENCE";
                PK_Number = 1;
                searchQuery = "SELECT * FROM CONFERENCE WHERE CITY = ";
                hint = "search conference by city";
                break;
            case "track":
                dbName = DATABASE_B;
                tableName = "TRACK";
                PK_Number = 1;
                searchQuery = "SELECT * FROM CONFERENCE@FIT5148A C, TRACK T WHERE C.CONFERENCE_ID = T.CONFERENCE_ID AND C.CONFERENCE_NAME = ";
                hint = "search track by conference name";
                break;
            case "author":
                dbName = DATABASE_B;
                tableName = "AUTHOR";
                PK_Number = 1;
                searchQuery = "SELECT * FROM AUTHOR WHERE COUNTRY = ";
                hint = "search author by country";
                break;
            case "pc member":
                dbName = DATABASE_B;
                tableName = "PC_MEMBER";
                PK_Number = 1;
                searchQuery = "SELECT * FROM PC_MEMBER WHERE AFFILIATION = ";
                hint = "search PC member by affiliation";
                break;
            case "review":
                dbName = DATABASE_B;
                tableName = "REVIEW";
                PK_Number = 2;
                searchQuery = "SELECT * FROM REVIEW WHERE RECOMMANDATION = ";
                hint = "search review by recommandation";
                break;
            case "submission":
                dbName = DATABASE_B;
                tableName = "SUBMISSION";
                PK_Number = 2;
                searchQuery = "SELECT * FROM SUBMISSION S, PAPER P, TRACK T, CONFERENCE@FIT5148A C WHERE S.PAPER_ID = P.PAPER_ID AND P.TRACK_ID = T.TRACK_ID AND T.CONFERENCE_ID = C.CONFERENCE_ID AND C.CONFERENCE_NAME = ";
                hint = "search submission by conference ???";
                break;
            case "paper":
                dbName = DATABASE_B;
                tableName = "PAPER";
                PK_Number = 1;
                searchQuery = "SELECT * FROM PAPER P, TRACK T, CONFERENCE@FIT5148A C WHERE P.TRACK_ID = T.TRACK_ID AND T.CONFERENCE_ID = C.CONFERENCE_ID AND C.CONFERENCE_NAME = ";
                hint = "search paper by conference ???";
                break;
            case "best paper award":
                dbName = DATABASE_B;
                tableName = "BEST_PAPER_AWARD";
                PK_Number = 2;
                searchQuery = "SELECT * FROM BEST_PAPER_AWARD B,TRACK T,CONFERENCE@FIT5148A C WHERE B.TRACK_ID = T.TRACK_ID AND T.CONFERENCE_ID = C.CONFERENCE_ID AND C.CONFERENCE_NAME = ";
                hint = "search best paper award by conference ???";
                break;
            default:
                dbName = null;
                tableName = null;
                PK_Number = 0;
                searchQuery = null;
                hint = null;
                break;
        }
        initComponents();
        getRootPane().setDefaultButton(btnRefresh);
        btnRefresh.requestFocusInWindow();
        setInfo("Load successfully");
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
        txtSearchWord = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(600, 400));

        view();
        tblContent.setModel(defaultTableModel);
        tblContent.getTableHeader().setReorderingAllowed(false);
        scrContent.setViewportView(tblContent);

        txtSearchWord.setText(hint);
        txtSearchWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchWordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchWordFocusLost(evt);
            }
        });
        txtSearchWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchWordActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.setPreferredSize(new java.awt.Dimension(100, 29));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.setPreferredSize(new java.awt.Dimension(100, 29));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnInsert.setPreferredSize(new java.awt.Dimension(100, 29));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 29));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 29));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrContent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtSearchWord, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInfo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addComponent(scrContent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnInsertActionPerformed
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (delete(getPKs())) {
            setInfo("Deleted successfully");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchWordActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtSearchWord.getText();
        if (keyword.isEmpty()) {
            lblInfo.setForeground(Color.red);
            lblInfo.setText("Please input a valid search key word.");
        } else {
            keyword = "\'" + keyword + "\'";
            searchBy(keyword);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        view();
        setInfo("Load successfully");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtSearchWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchWordFocusLost
        // TODO add your handling code here:
        if (txtSearchWord.getText().isEmpty()) {
            txtSearchWord.setText(hint);
        }
    }//GEN-LAST:event_txtSearchWordFocusLost

    private void txtSearchWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchWordFocusGained
        // TODO add your handling code here:
        if (txtSearchWord.getText().equalsIgnoreCase(hint)) {
            txtSearchWord.setText(null);
        }
    }//GEN-LAST:event_txtSearchWordFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JScrollPane scrContent;
    private javax.swing.JTable tblContent;
    private javax.swing.JTextField txtSearchWord;
    // End of variables declaration//GEN-END:variables

    public String getPKs() {
        StringBuffer sb = new StringBuffer();
        for (int i : tblContent.getSelectedRows()) {
            for (int j = 0; j < PK_Number; j++) {
//                test
                //pk name
//                System.out.print(tblContent.getColumnName(j));
                //pk value
//                System.out.println(tblContent.getValueAt(i, j));
                //append column name
                sb.append(tblContent.getColumnName(j));
                sb.append("=");
                //append value
                sb.append(tblContent.getValueAt(i, j));

                if (j != PK_Number - 1) {
                    sb.append(" AND ");
                }
            }
            sb.append(" OR ");
        }
        sb.delete(sb.lastIndexOf(" OR "), sb.length());
        //System.out.println();
        return sb.toString();
    }

    @Override
    public void view() {
        setInfo("Loading...");
        Connection connection = null;
        try {
            //link to db
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + tableName);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            //make headers
            int columnCount = resultSetMetaData.getColumnCount();
            Object[] headers = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headers[i - 1] = resultSetMetaData.getColumnName(i);
            }
            defaultTableModel = new DefaultTableModel(headers, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            //make data
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                defaultTableModel.addRow(rowData);
            }
            tblContent.setModel(defaultTableModel);
        } catch (SQLException e) {
            setErrorInfo(e);
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException ex) {
                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insert(String[] values, String[] columns) {
        return true;
    }

    @Override
    public boolean update(String[] values, String[] columns, String condition) {
        return true;
    }

    @Override
    public boolean delete(String condition) {
        setInfo("Deleteling...");
        Connection connection = null;
        try {
            //link to db
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            System.out.println(statement.executeUpdate("delete from " + tableName + " where " + condition));
            view();
            return true;
        } catch (SQLException e) {
            //Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
            setErrorInfo(e);
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException ex) {
                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void searchBy(String condition) {
        setInfo("Searching...");
        Connection connection = null;
        try {
            //link to db
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery + condition);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            //make headers
            int columnCount = resultSetMetaData.getColumnCount();
            Object[] headers = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headers[i - 1] = resultSetMetaData.getColumnName(i);
            }
            defaultTableModel = new DefaultTableModel(headers, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            //make data
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                defaultTableModel.addRow(rowData);
            }
            tblContent.setModel(defaultTableModel);
            setInfo("Search successfully");
        } catch (SQLException e) {
            setErrorInfo(e);
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException ex) {
                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setInfo(String info) {
        lblInfo.setForeground(Color.black);
        lblInfo.setText(info);
    }

    private void setErrorInfo(SQLException e) {
        System.out.println(e.getErrorCode());
        lblInfo.setForeground(Color.red);
        switch (e.getErrorCode()) {
            case 20001:
                lblInfo.setText("A paper can be reviewd by at most 3 people.");
                break;
            case 20002:
                lblInfo.setText("Violation to the remote reference intergrity on delete or update");
                break;
            case 20003:
                lblInfo.setText("One corresponding author for each paper at max");
                break;
            case 17002:
                lblInfo.setText("Connection error, please check your internet connection");
                break;
            case 2292:
                lblInfo.setText("Violation to the reference intergrity on delete");
                break;
            default:
                lblInfo.setText("Something wrong, please try again latter.");
                break;
        }
    }
}
