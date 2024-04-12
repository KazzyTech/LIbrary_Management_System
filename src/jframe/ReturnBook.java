/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Kazzy
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    
    
    
//    to fetch the issue book details from the database and display it to the  panel 
    public void getIssueBookDetails() {
        int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where id = ? and student_id = ?  ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
//            pst.setString(3, "pending");
            
           ResultSet rs =  pst.executeQuery();
           
           if (rs.next()) {
               
               lbl_issueid.setText (rs.getString("id"));
               lbl_bookName.setText(rs.getString("book_name"));
               lbl_studentName.setText(rs.getString("student_name"));
               lbl_issueDate.setText(rs.getString("issue_date"));
               lbl_dueDate.setText(rs.getString("due_date"));
               lbl_bookError.setText(rs.getString(""));
           } else {
               lbl_bookError.setText("No Record Found");
               
               lbl_issueid.setText ("");
               lbl_bookName.setText("");
               lbl_studentName.setText("");
               lbl_issueDate.setText("");
               lbl_dueDate.setText("");
           
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
//    return the book
    public boolean returnBook() {
        boolean isReturned = false;
        int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status =? where student_id =? and book_id=? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId); 
            pst.setString(4, "pending");
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isReturned = true;
            } else {
                isReturned = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturned;
    }

    
 
    

    
//    updating book count
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookid.getText());
       
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity + 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count updated");
            } else {
                JOptionPane.showMessageDialog(this, "can't update book");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_issueDate = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_issueid = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        txt_studentid = new app.bolivia.swing.JCTextField();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel13.setText("Book Details");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 80));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, 5));

        lbl_issueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jPanel6.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, 40));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setText("Book Name :");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setText("Student Name :");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 150, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setText("Issue Date :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 120, -1));

        lbl_issueid.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jPanel6.add(lbl_issueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 150, 40));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jPanel6.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, 40));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jPanel6.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 150, 40));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel6.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 200, 50));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel19.setText("Due Date :");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 120, -1));

        lbl_dueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jPanel6.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 150, 40));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel22.setText("Issue Id :");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 120, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 340, 630));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(251, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("  Return Book");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, 270, 50));

        jPanel9.setBackground(new java.awt.Color(251, 51, 51));
        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, 280, 5));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("Student Id :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 120, -1));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("Book Id :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, 120, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Return Book");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 490, 250, 60));

        txt_studentid.setBackground(new java.awt.Color(255, 255, 255));
        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(251, 51, 51)));
        txt_studentid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentid.setPlaceholder("Enter student id ...");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 290, 180, 40));

        txt_bookid.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(251, 51, 51)));
        txt_bookid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookid.setPlaceholder("Enter book id ...");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 180, 210, 40));

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel12.setText("Back");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, 20));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle3.setText("Find");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 420, 250, 60));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 590, 490));

        jPanel4.setBackground(new java.awt.Color(251, 51, 51));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 630));

        setSize(new java.awt.Dimension(1280, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if (returnBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Returned Successfully");
            updateBookCount();
        } else {
            JOptionPane.showMessageDialog(this, "Book Returned Fail");
        }
       
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueid;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
