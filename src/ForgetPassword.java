import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ForgetPassword extends JFrame {
    public ForgetPassword() {
        setResizable(false);
        initComponents();
        //setLocationRelativeTo(Server.this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 400);
        jLabelConfirmPassFP.setVisible(false);
        jLabelNewPassFP.setVisible(false);
        jLabelAnsFP.setVisible(false);
        jLabelQuesFP.setVisible(false);
        tfcpansff.setVisible(false);
        tfcpnewpassff.setVisible(false);
        tfcpconfffff.setVisible(false);
        btChangePassFG.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelForgetPassFP = new JLabel();
        jLabelPhoneFP = new JLabel();
        jLabelQuesFP = new JLabel();
        jLabelNewPassFP = new JLabel();
        jLabelConfirmPassFP = new JLabel();
        btChangePassFG = new JButton();
        tfcpphonef = new JTextField();
        tfcpconfffff = new JPasswordField();
        tfcpansff = new JPasswordField();
        tfcpnewpassff = new JPasswordField();
        jLabelAnsFP = new JLabel();
        lbQuesFP = new JLabel();
        btNextFP = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelForgetPassFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelForgetPassFP.setText("FORGET PASSWORD");
        getContentPane().add(jLabelForgetPassFP);
        jLabelForgetPassFP.setBounds(110, 10, 140, 14);

        jLabelPhoneFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPhoneFP.setText("Phone No.");
        getContentPane().add(jLabelPhoneFP);
        jLabelPhoneFP.setBounds(10, 60, 80, 15);

        jLabelQuesFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelQuesFP.setText("Security Ques.");
        getContentPane().add(jLabelQuesFP);
        jLabelQuesFP.setBounds(10, 100, 90, 30);

        jLabelNewPassFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelNewPassFP.setText("New password");
        getContentPane().add(jLabelNewPassFP);
        jLabelNewPassFP.setBounds(10, 190, 100, 15);

        jLabelConfirmPassFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelConfirmPassFP.setText("Confirm pass.");
        getContentPane().add(jLabelConfirmPassFP);
        jLabelConfirmPassFP.setBounds(10, 230, 110, 15);

        btChangePassFG.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btChangePassFG.setText("SUBMIT");
        btChangePassFG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePassFG);
        btChangePassFG.setBounds(140, 270, 80, 23);
        getContentPane().add(tfcpphonef);
        tfcpphonef.setBounds(150, 50, 140, 30);
        getContentPane().add(tfcpconfffff);
        tfcpconfffff.setBounds(150, 230, 140, 30);
        getContentPane().add(tfcpansff);
        tfcpansff.setBounds(150, 150, 140, 30);
        getContentPane().add(tfcpnewpassff);
        tfcpnewpassff.setBounds(150, 190, 140, 30);

        jLabelAnsFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAnsFP.setText("Security Ans.");
        getContentPane().add(jLabelAnsFP);
        jLabelAnsFP.setBounds(10, 140, 90, 30);
        getContentPane().add(lbQuesFP);
        lbQuesFP.setBounds(150, 90, 250, 50);

        btNextFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btNextFP.setText("NEXT");
        btNextFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextActionPerformed(evt);
            }
        });
        getContentPane().add(btNextFP);
        btNextFP.setBounds(300, 50, 70, 30);

        pack();
    }// </editor-fold>

    private void btChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        String phone, password, newPass, confirmPass;

        phone = tfcpphonef.getText();
        password = tfcpansff.getText();
        newPass = tfcpnewpassff.getText();
        confirmPass = tfcpconfffff.getText();

        if (phone.equals("") || password.equals("") || newPass.equals("") || (confirmPass.equals(""))) {
            JOptionPane.showMessageDialog(this, "All Fields are compulsary");
        } else if (!newPass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(this, "Confirm password is different");
        } else {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + phone + "'and seq_ans = '" + password + "'");
                if (rs.next()) {
                    rs.updateString("password", newPass);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(this, "Password Changed");

                    this.setVisible(false);
                    //openmain();

                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Answer");
                }

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception ex) {

            }

        }
    }

    private void btNextActionPerformed(java.awt.event.ActionEvent evt) {
        String pno = tfcpphonef.getText();
        if (pno.length() < 10) {
            JOptionPane.showMessageDialog(this, "Phone no. should be of 10 digit");
        } else {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + pno + "'");
                if (rs.next()) {
                    String ques = rs.getString("seq_ques");
                    jLabelConfirmPassFP.setVisible(true);
                    jLabelNewPassFP.setVisible(true);
                    jLabelAnsFP.setVisible(true);
                    jLabelQuesFP.setVisible(true);
                    tfcpansff.setVisible(true);
                    tfcpnewpassff.setVisible(true);
                    tfcpconfffff.setVisible(true);
                    btChangePassFG.setVisible(true);
                    lbQuesFP.setText(ques + "  ?");

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid User");
                }

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    // Variables declaration - do not modify
    private JButton btChangePassFG;
    private JButton btNextFP;
    private JLabel jLabelForgetPassFP;
    private JLabel jLabelPhoneFP;
    private JLabel jLabelQuesFP;
    private JLabel jLabelAnsFP;
    private JLabel jLabelNewPassFP;
    private JLabel jLabelConfirmPassFP;
    private JLabel lbQuesFP;
    private JPasswordField tfcpansff;
    private JPasswordField tfcpconfffff;
    private JPasswordField tfcpnewpassff;
    private JTextField tfcpphonef;
    // End of variables declaration
}