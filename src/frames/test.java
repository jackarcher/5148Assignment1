/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Archer
 */
public class test {

    public static void main(String[] s) {
        Connection connection = null;
        try {
            //link to db
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a",
                    "S26298090", "student");
            System.out.println("Connceted to Oracle");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into conference values("
                    + "SEQ_CONFERENCE.NEXTVAL,'test from java', 2020,"
                    + "TO_DATE('2020-02-01','yyyy-mm-dd'),"
                    + "TO_DATE('2020-04-13','yyyy-mm-dd'),"
                    + "'AUSTRALIA','MELBOURNE','30 COLLINS ST',"
                    + "'conferencecentre@monash.edu')");
            System.out.println();
        } catch (SQLException e) {
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
}
