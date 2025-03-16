import javax.swing.*;
import java.sql.*;

public class ChangePassword extends javax.swing.JFrame {

    public ChangePassword() {
        setResizable(false);
        initComponents();
        //setLocationRelativeTo(Server.this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 350);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelChagePassCP = new javax.swing.JLabel();
        jLabelPhoneCP = new javax.swing.JLabel();
        jLabelPasswordCP = new javax.swing.JLabel();
        jLabelNewPassCP = new javax.swing.JLabel();
        jLabelConfirmPassCP = new javax.swing.JLabel();
        btChangePass = new javax.swing.JButton();
        tfPhoneCP = new javax.swing.JTextField();
        tfConfirmCP = new javax.swing.JPasswordField();
        tfPasswordCP = new javax.swing.JPasswordField();
        tfNewPassCP = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelChagePassCP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelChagePassCP.setText("CHANGE PASSWORD");
        getContentPane().add(jLabelChagePassCP);
        jLabelChagePassCP.setBounds(110, 10, 140, 14);

        jLabelPhoneCP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPhoneCP.setText("Phone No.");
        getContentPane().add(jLabelPhoneCP);
        jLabelPhoneCP.setBounds(10, 60, 80, 15);

        jLabelPasswordCP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPasswordCP.setText("Password");
        getContentPane().add(jLabelPasswordCP);
        jLabelPasswordCP.setBounds(10, 100, 70, 15);

        jLabelNewPassCP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelNewPassCP.setText("New password");
        getContentPane().add(jLabelNewPassCP);
        jLabelNewPassCP.setBounds(10, 140, 100, 15);

        jLabelConfirmPassCP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelConfirmPassCP.setText("Confirm pass.");
        getContentPane().add(jLabelConfirmPassCP);
        jLabelConfirmPassCP.setBounds(10, 180, 110, 15);

        btChangePass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btChangePass.setText("SUBMIT");
        btChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePass);
        btChangePass.setBounds(140, 230, 80, 23);
        getContentPane().add(tfPhoneCP);
        tfPhoneCP.setBounds(150, 50, 140, 30);
        getContentPane().add(tfConfirmCP);
        tfConfirmCP.setBounds(150, 180, 140, 30);
        getContentPane().add(tfPasswordCP);
        tfPasswordCP.setBounds(150, 100, 140, 30);
        getContentPane().add(tfNewPassCP);
        tfNewPassCP.setBounds(150, 140, 140, 30);

        pack();
    }// </editor-fold>

    private void btChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        String phn, passw, newp, chpass;

        phn = tfPhoneCP.getText();
        passw = tfPasswordCP.getText();
        newp = tfNewPassCP.getText();
        chpass = tfConfirmCP.getText();

        if (phn.equals("") || passw.equals("") || newp.equals("") || (chpass.equals(""))) {
            JOptionPane.showMessageDialog(this, "All Fields are compulsary");
        } else if (phn.length() != 10) {
            JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
        } else if (!newp.equals(chpass)) {
            JOptionPane.showMessageDialog(this, "Confirm password is different");
        } else {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + phn + "'and password = '" + passw + "'");
                if (rs.next()) {
                    rs.updateString("password", newp);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(this, "Password Changed");

                    this.setVisible(false);
                    //openmain();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid User");
                }

                rs.close();
                stmt.close();
                connection.close();

            } catch (Exception ex) {

            }

        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btChangePass;
    private javax.swing.JLabel jLabelChagePassCP;
    private javax.swing.JLabel jLabelPhoneCP;
    private javax.swing.JLabel jLabelPasswordCP;
    private javax.swing.JLabel jLabelNewPassCP;
    private javax.swing.JLabel jLabelConfirmPassCP;
    private javax.swing.JPasswordField tfConfirmCP;
    private javax.swing.JPasswordField tfNewPassCP;
    private javax.swing.JPasswordField tfPasswordCP;
    private javax.swing.JTextField tfPhoneCP;
    // End of variables declaration                   
}