/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Archer
 */
public class MainFrame extends javax.swing.JFrame {// implements FunctionalInterface{

    private final BasicFrame conference = new BasicFrame("Conference");
    private final BasicFrame track = new BasicFrame("Track");
    private final BasicFrame author = new BasicFrame("Author");
    private final BasicFrame PC_Member = new BasicFrame("PC member");
    private final BasicFrame review = new BasicFrame("Review");
    private final BasicFrame submission = new BasicFrame("Submission");
    private final BasicFrame paper = new BasicFrame("Paper");
    private final BasicFrame bestPaperAward = new BasicFrame("Best Paper Award");

    //due to the DB server fail, chagne stratige, never release the connection
    public static java.sql.Connection CONNECTION_DB_A = null;

    public static java.sql.Connection CONNECTION_DB_B = null;

    static {
        try {
            CONNECTION_DB_A = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a", "S26298090", "student");
            System.out.println("Connected to DB_A");
            CONNECTION_DB_B = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148b", "S26298090", "student");
            System.out.println("Connected to DB_B");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (CONNECTION_DB_A != null) {
                    CONNECTION_DB_A.close();
                    System.out.println("Connection to DB_A closed");
                }
                if (CONNECTION_DB_B != null) {
                    CONNECTION_DB_B.close();
                    System.out.println("Connection to DB_B closed");
                }
            } catch (SQLException exx) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, exx);
            }
        }
    }

    //test use only
//    private final BasicFrame track = null;
//    private final BasicFrame author = null;
//    private final BasicFrame PC_Member = null;
//    private final BasicFrame review = null;
//    private final BasicFrame submission = null;
//    private final BasicFrame paper = null;
//    private final BasicFrame bestPaperAward = null;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        myDetail = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        btnConference = new javax.swing.JButton();
        btnTrack = new javax.swing.JButton();
        btnAuthor = new javax.swing.JButton();
        btnPC_Member = new javax.swing.JButton();
        btnReview = new javax.swing.JButton();
        btnSubmission = new javax.swing.JButton();
        btnPaper = new javax.swing.JButton();
        btnBestPaperAward = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Assignment 1 of FIT5148: Distributed and big data processing");
        setResizable(false);

        myDetail.setText("ID: 26298090\nName: Zhuoran Tian");
        myDetail.setToolTipText("");

        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("Welcom, please click the buttons below to check different features.");

        btnConference.setText("Conference");
        btnConference.setBounds(new java.awt.Rectangle(0, 0, 150, 30));
        btnConference.setPreferredSize(new java.awt.Dimension(150, 30));
        btnConference.setSize(new java.awt.Dimension(150, 30));
        btnConference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConferenceActionPerformed(evt);
            }
        });

        btnTrack.setText("Track");
        btnTrack.setBounds(new java.awt.Rectangle(0, 0, 150, 30));
        btnTrack.setPreferredSize(new java.awt.Dimension(150, 30));
        btnTrack.setSize(new java.awt.Dimension(150, 30));
        btnTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackActionPerformed(evt);
            }
        });

        btnAuthor.setText("Author");
        btnAuthor.setPreferredSize(new java.awt.Dimension(150, 30));
        btnAuthor.setSize(new java.awt.Dimension(150, 30));
        btnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthorActionPerformed(evt);
            }
        });

        btnPC_Member.setText("PC Member");
        btnPC_Member.setToolTipText("");
        btnPC_Member.setPreferredSize(new java.awt.Dimension(150, 30));
        btnPC_Member.setSize(new java.awt.Dimension(150, 30));
        btnPC_Member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPC_MemberActionPerformed(evt);
            }
        });

        btnReview.setText("Review");
        btnReview.setPreferredSize(new java.awt.Dimension(150, 30));
        btnReview.setSize(new java.awt.Dimension(150, 30));
        btnReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewActionPerformed(evt);
            }
        });

        btnSubmission.setText("Submission");
        btnSubmission.setPreferredSize(new java.awt.Dimension(150, 30));
        btnSubmission.setSize(new java.awt.Dimension(150, 30));
        btnSubmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmissionActionPerformed(evt);
            }
        });

        btnPaper.setText("Paper");
        btnPaper.setPreferredSize(new java.awt.Dimension(150, 30));
        btnPaper.setSize(new java.awt.Dimension(150, 30));
        btnPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaperActionPerformed(evt);
            }
        });

        btnBestPaperAward.setText("Best Paper Award");
        btnBestPaperAward.setPreferredSize(new java.awt.Dimension(150, 30));
        btnBestPaperAward.setSize(new java.awt.Dimension(150, 30));
        btnBestPaperAward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestPaperAwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPC_Member, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubmission, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConference, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBestPaperAward, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPC_Member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBestPaperAward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(myDetail))
                    .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myDetail)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConferenceActionPerformed
        // TODO add your handling code here:
        conference.setVisible(!conference.isShowing());
    }//GEN-LAST:event_btnConferenceActionPerformed

    private void btnTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackActionPerformed
        // TODO add your handling code here:
        track.setVisible(!track.isShowing());
    }//GEN-LAST:event_btnTrackActionPerformed

    private void btnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthorActionPerformed
        // TODO add your handling code here:
        author.setVisible(!author.isShowing());
    }//GEN-LAST:event_btnAuthorActionPerformed

    private void btnPC_MemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPC_MemberActionPerformed
        // TODO add your handling code here:
        PC_Member.setVisible(!PC_Member.isShowing());
    }//GEN-LAST:event_btnPC_MemberActionPerformed

    private void btnReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewActionPerformed
        // TODO add your handling code here:
        review.setVisible(!review.isShowing());
    }//GEN-LAST:event_btnReviewActionPerformed

    private void btnSubmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmissionActionPerformed
        // TODO add your handling code here:
        submission.setVisible(!submission.isShowing());
    }//GEN-LAST:event_btnSubmissionActionPerformed

    private void btnPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaperActionPerformed
        // TODO add your handling code here:
        paper.setVisible(!paper.isShowing());
    }//GEN-LAST:event_btnPaperActionPerformed

    private void btnBestPaperAwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestPaperAwardActionPerformed
        // TODO add your handling code here:
        bestPaperAward.setVisible(!bestPaperAward.isShowing());
    }//GEN-LAST:event_btnBestPaperAwardActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                mainFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        try {
                            CONNECTION_DB_A.close();
                            System.out.println("Connection to DB_A closed");
                            CONNECTION_DB_B.close();
                            System.out.println("Connection to DB_B closed");
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthor;
    private javax.swing.JButton btnBestPaperAward;
    private javax.swing.JButton btnConference;
    private javax.swing.JButton btnPC_Member;
    private javax.swing.JButton btnPaper;
    private javax.swing.JButton btnReview;
    private javax.swing.JButton btnSubmission;
    private javax.swing.JButton btnTrack;
    private javax.swing.JLabel description;
    private javax.swing.JLabel myDetail;
    private javax.swing.JPanel pnlButtons;
    // End of variables declaration//GEN-END:variables
}
