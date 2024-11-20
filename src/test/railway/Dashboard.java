
package test.railway;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nanay
 */
public class Dashboard extends javax.swing.JFrame {

    // Database connection variables
    Connection con;
    PreparedStatement pst;

    public Dashboard() {
        initComponents();
        connect(); // Establish database connection on initialization
    }

    public void connect() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database (adjust port, username, password if necessary)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?useSSL=false", "root", "123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, "Driver not found", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, "Database connection failed", ex);
        }
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tstartplace = new javax.swing.JTextField();
        tdplace = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Train No");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel3.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 210, -1));

        jLabel2.setText("Price");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));
        jPanel3.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 210, -1));

        jLabel3.setText("Train Nmae");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        jPanel3.add(tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 210, -1));

        jLabel4.setText("Start Place");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));
        jPanel3.add(tstartplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 210, -1));
        jPanel3.add(tdplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 210, -1));

        jLabel5.setText("End Place");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 370, 330));

        jButton1.setText("Add Train");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jButton2.setText("Delete");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        jButton3.setText("Edit");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 330, 430));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Add Train");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String tno = txtno.getText();
        String trainname = tname.getText();
        String splace = tstartplace.getText();
        String dplace = tdplace.getText();
        String price = txtprice.getText();
        
        try {
            pst = con.prepareStatement("insert into traindetails(tno, tname,startplace,destinationplace,price)values(?,?,?,?,?) ");
            pst.setString(1, tno);
            pst.setString(2, trainname);
            pst.setString(3, splace);
            pst.setString(4, dplace);
            pst.setString(1, price);
            int k = pst.executeUpdate();
            
            if(k==1)
            {
             JOptionPane.showMessageDialog(this,"Record Added");
            }
            else
            {
               JOptionPane.showMessageDialog(this,"Record Failed"); 
            }
            
            txtno.setText("");
            tname.setText("");
            tstartplace.setText("");
            tdplace.setText("");
            txtprice.setText("");
            txtno.requestFocus();
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tdplace;
    private javax.swing.JTextField tname;
    private javax.swing.JTextField tstartplace;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
