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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    private Object[] headers;

    //might be temp use
    private Connection connection;

    /**
     * Creates new form BasicFrame
     */
    public BasicFrame(String frameTitle) {
        setTitle(frameTitle + " Frame");
        connection = MainFrame.CONNECTION_DB_B;
        switch (frameTitle.toLowerCase()) {
            case "conference":
                dbName = DATABASE_A;
                connection = MainFrame.CONNECTION_DB_A;
                tableName = "CONFERENCE";
                PK_Number = 1;
                searchQuery = "SELECT * FROM CONFERENCE WHERE UPPER(CITY) = ";
                hint = "search conference by city";
                break;
            case "track":
                dbName = DATABASE_B;
                tableName = "TRACK";
                PK_Number = 1;
                searchQuery = "SELECT * FROM CONFERENCE@FIT5148A C, TRACK T WHERE C.CONFERENCE_ID = T.CONFERENCE_ID AND UPPER(C.CONFERENCE_NAME) = ";
                hint = "search track by conference name";
                break;
            case "author":
                dbName = DATABASE_B;
                tableName = "AUTHOR";
                PK_Number = 1;
                searchQuery = "SELECT * FROM AUTHOR WHERE UPPER(COUNTRY) = ";
                hint = "search author by country";
                break;
            case "pc member":
                dbName = DATABASE_B;
                tableName = "PC_MEMBER";
                PK_Number = 1;
                searchQuery = "SELECT * FROM PC_MEMBER WHERE UPPER(AFFILIATION) = ";
                hint = "search PC member by affiliation";
                break;
            case "review":
                dbName = DATABASE_B;
                tableName = "REVIEW";
                PK_Number = 2;
                searchQuery = "SELECT * FROM REVIEW WHERE UPPER(RECOMMENDATION) = ";
                hint = "search review by recommendation";
                break;
            case "submission":
                dbName = DATABASE_B;
                tableName = "SUBMISSION";
                PK_Number = 2;
                searchQuery = "SELECT * FROM SUBMISSION S, PAPER P, TRACK T, CONFERENCE@FIT5148A C WHERE S.PAPER_ID = P.PAPER_ID AND P.TRACK_ID = T.TRACK_ID AND T.CONFERENCE_ID = C.CONFERENCE_ID AND UPPER(C.CONFERENCE_NAME) = ";
                hint = "search submission by conference name";
                break;
            case "paper":
                dbName = DATABASE_B;
                tableName = "PAPER";
                PK_Number = 1;
                searchQuery = "SELECT * FROM PAPER P, TRACK T, CONFERENCE@FIT5148A C WHERE P.TRACK_ID = T.TRACK_ID AND T.CONFERENCE_ID = C.CONFERENCE_ID AND UPPER(C.CONFERENCE_NAME) = ";
                hint = "search paper by conference name";
                break;
            case "best paper award":
                dbName = DATABASE_B;
                tableName = "BEST_PAPER_AWARD";
                PK_Number = 2;
                searchQuery = "SELECT * FROM BEST_PAPER_AWARD B,TRACK T,CONFERENCE@FIT5148A C WHERE B.TRACK_ID = T.TRACK_ID AND T.CONFERENCE_ID = C.CONFERENCE_ID AND UPPER(C.CONFERENCE_NAME) = ";
                hint = "search best paper award by conference name";
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
        dynSearchWord = new javax.swing.JTextField();
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

        dynSearchWord.setText(hint);
        dynSearchWord.setForeground(Color.gray);
        dynSearchWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dynSearchWordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dynSearchWordFocusLost(evt);
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
                            .addComponent(dynSearchWord, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
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
                    .addComponent(dynSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        InputDialog insertDialog = new InputDialog(this, "Insert for " + tableName, headers);
        insertDialog.setVisible(true);
        insertDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setInfo("Inserting...");
                if (insert(insertDialog.getValues())) {
                    view();
                    setInfo("Inserted successful");
                }
            }
        });
    }//GEN-LAST:event_btnInsertActionPerformed
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //find selected rows
        int[] selectedRows = tblContent.getSelectedRows();
        Object[][] subTable = new Object[selectedRows.length][tblContent.getColumnCount()];
        for (int i = 0; i < selectedRows.length; i++) {
            for (int j = 0; j < tblContent.getColumnCount(); j++) {
                subTable[i][j] = tblContent.getValueAt(selectedRows[i], j);
            }
        }

        InputDialog updateDialog = new InputDialog(this, "Update for " + tableName, headers, PK_Number, subTable);
        updateDialog.setVisible(true);
        updateDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setInfo("Updating...");
                if (update(updateDialog.getUpdatedData())) {
                    view();
                    setInfo("Updated successful");
                }
            }
        });

    }//GEN-LAST:event_btnUpdateActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        setInfo("Deleteling...");
        if (delete(getPKs())) {
            setInfo("Deleted successfully");
        }
        view();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        setInfo("Searching...");
        String keyword = dynSearchWord.getText();
        if (keyword.isEmpty()) {
            lblInfo.setForeground(Color.red);
            lblInfo.setText("Please input a valid search key word.");
        } else {
            keyword = "upper(\'" + keyword + "\')";
            searchBy(keyword);
            setInfo("Search finish");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        setInfo("Loading...");
        view();
        setInfo("Load successfully");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void dynSearchWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dynSearchWordFocusLost
        // TODO add your handling code here:
        if (dynSearchWord.getText().isEmpty()) {
            dynSearchWord.setForeground(Color.gray);
            dynSearchWord.setText(hint);
        }
    }//GEN-LAST:event_dynSearchWordFocusLost

    private void dynSearchWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dynSearchWordFocusGained
        // TODO add your handling code here:
        if (dynSearchWord.getText().equalsIgnoreCase(hint)) {
            dynSearchWord.setText(null);
            dynSearchWord.setForeground(Color.black);
        }
    }//GEN-LAST:event_dynSearchWordFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField dynSearchWord;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JScrollPane scrContent;
    private javax.swing.JTable tblContent;
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
//        Connection connection = null;
        try {
            //link to db
//            DriverManager.registerDriver(new OracleDriver());
//            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
//            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + tableName);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //make headers
            int columnCount = resultSetMetaData.getColumnCount();
            headers = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headers[i - 1] = resultSetMetaData.getColumnName(i);
            }
            defaultTableModel = new DefaultTableModel(headers, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
//                    return row > getRowCount();
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
            System.out.println(tableName + " row no : " + defaultTableModel.getRowCount());
        } catch (SQLException e) {
            setErrorInfo(e);
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
        }
//        finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                    System.out.println("Connection closed");
//                } catch (SQLException ex) {
//                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    @Override
    public boolean insert(String[] values) {
//        Connection connection = null;
        try {
            //link to db
//            DriverManager.registerDriver(new OracleDriver());
//            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
//            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            //prepare for generate sql
            ResultSet resultSet = statement.executeQuery("select * from " + tableName);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < values.length; i++) {
                //append based on type
                switch (resultSetMetaData.getColumnType(i + 1)) {
                    case 2:
                        //NUMERIC
                        sb.append(values[i]);
                        sb.append(",");
                        break;
                    case 12:
                        //VARCHAR
                        sb.append("'");
                        sb.append(values[i]);
                        sb.append("',");
                        break;
                    case 93:
                        //DATE
                        sb.append("TO_DATE('");
                        sb.append(values[i]);
                        sb.append("','yyyy-mm-dd'),");
                        break;
                    default:
                        break;
                }
            }
            sb.delete(sb.lastIndexOf(","), sb.length());
            String sql = "insert into " + tableName + " values(" + sb.toString() + ")";
            statement.executeUpdate(sql);
            System.out.println(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
//            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
            setErrorInfo(e);
            return false;
        }
//        finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                    System.out.println("Connection closed");
//                } catch (SQLException ex) {
//                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    @Override
    public boolean update(String[][] updatedData) {
        //try preparedStatement
        PreparedStatement preparedUpdateStatement = null;

        //generate the fixed part of the statement
        StringBuffer updateSql = new StringBuffer("update " + tableName + " set ");
        for (int i = PK_Number; i < tblContent.getColumnCount(); i++) {
            updateSql.append(tblContent.getColumnName(i));
            updateSql.append(" = ?");
            if (i != tblContent.getColumnCount() - 1) {
                updateSql.append(" ,");
            }
        }
        updateSql.append(" where ");
        for (int i = 0; i < PK_Number; i++) {
            updateSql.append(tblContent.getColumnName(i));
            updateSql.append(" = ?");
            if (i != PK_Number - 1) {
                updateSql.append(" and ");
            }
        }
//        Connection connection = null;
        try {
            //link to db
//            DriverManager.registerDriver(new OracleDriver());
//            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
//            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + tableName);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            connection.setAutoCommit(false);
            //prepare statement
            System.out.println("Prepared sql:" + updateSql.toString());
            preparedUpdateStatement = connection.prepareStatement(updateSql.toString());
            for (int i = 0; i < updatedData.length; i++) {
                //set values for each row
                int setPosition = 1;
                for (int j = PK_Number; j < updatedData[0].length; j++, setPosition++) {
                    String cellData = updatedData[i][j];
                    switch (resultSetMetaData.getColumnType(j + 1)) {
                        case 2:
                            //NUMERIC
                            System.out.print("set " + setPosition + " numeric ");
                            preparedUpdateStatement.setBigDecimal(setPosition, new BigDecimal(cellData));
                            break;
                        case 12:
                            //VARCHAR
                            System.out.print("set " + setPosition + " varchar ");
                            preparedUpdateStatement.setString(setPosition, cellData);
                            break;
                        case 93:
                            //DATE
                            System.out.print("set " + setPosition + " date ");
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            preparedUpdateStatement.setDate(setPosition, new java.sql.Date(df.parse(cellData).getTime()));
                            break;
                        default:
                            break;
                    }
                    System.out.print(cellData + " | ");
                }
                for (int j = 0; j < PK_Number; j++, setPosition++) {
                    String cellData = updatedData[i][j];
                    switch (resultSetMetaData.getColumnType(j + 1)) {
                        case 2:
                            //NUMERIC
                            System.out.print("set " + setPosition + " numeric ");
                            preparedUpdateStatement.setBigDecimal(setPosition, new BigDecimal(cellData));
                            break;
                        case 12:
                            //VARCHAR
                            System.out.print("set " + setPosition + " varchar ");
                            preparedUpdateStatement.setString(setPosition, cellData);
                            break;
                        case 93:
                            //DATE
                            System.out.print("set " + setPosition + " date ");
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            preparedUpdateStatement.setDate(setPosition, new java.sql.Date(df.parse(cellData).getTime()));
                            break;
                        default:
                            break;
                    }
                    System.out.print(cellData + " | ");
                }
                preparedUpdateStatement.executeUpdate();
                System.out.println();
            }
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
            return true;
        } catch (SQLException e) {
            //            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
            setErrorInfo(e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    setErrorInfo(ex);
                }
            }
            return false;
        } catch (ParseException ex) {
            //TODO
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
//        finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                    System.out.println("Connection closed");
//                } catch (SQLException ex) {
//                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    @Override
    public boolean delete(String condition) {
//        Connection connection = null;
        try {
            //link to db
//            DriverManager.registerDriver(new OracleDriver());
//            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
//            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            System.out.println(statement.executeUpdate("delete from " + tableName + " where " + condition));
            statement.close();
            return true;
        } catch (SQLException e) {
            //Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
            setErrorInfo(e);
            return false;
        }
//        finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                    System.out.println("Connection closed");
//                } catch (SQLException ex) {
//                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    @Override
    public void searchBy(String condition) {
//        Connection connection = null;
        try {
            //link to db
//            DriverManager.registerDriver(new OracleDriver());
//            connection = DriverManager.getConnection(dbName, USERNAME, PWD);
//            System.out.println("Connceted to Oracle");
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
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            setErrorInfo(e);
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, e);
        }
//        finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                    System.out.println("Connection closed");
//                } catch (SQLException ex) {
//                    Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
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
                lblInfo.setText("Violation to the remote reference intergrity");
                break;
            case 20003:
                lblInfo.setText("One corresponding author for each paper at max");
                break;
            case 17002:
                lblInfo.setText("Connection error, please check your internet connection");
                break;
            case 2292:
                lblInfo.setText("Violate to the reference intergrity on delete");
                break;
            case 2290:
                lblInfo.setText("Fail to pass the table intergrity check");
                break;
            case 1:
                lblInfo.setText("Primary key or other unique check fail.");
                break;
            case 1400:
                lblInfo.setText("Primary key or not null check fail.");
                break;
            case 12519:
                System.exit(1);
                break;
            default:
                lblInfo.setText("Something wrong, please try again latter. Error code:" + e.getErrorCode());
                break;
        }
        e.printStackTrace();
    }
}
