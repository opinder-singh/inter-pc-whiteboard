import javax.swing.*;
import java.io.DataOutputStream;

public class ForgetPassword extends javax.swing.JFrame {
    // Variables declaration - do not modify
    DataOutputStream mDOS=null;
    JButton btChangePassFP;
    JButton btNextFP;
    JLabel jLabelForgetFP;
    JLabel jLabelPhoneFP;
    JLabel jLabelQuesFP;
    JLabel jLabelAnsFP;
    JLabel jLabelNewPassFP;
    JLabel jLabelConfirmPassFP;
    JLabel lbQuestionFP;
    JPasswordField tfAnsFP;
    JPasswordField tfConfirmPassFP;
    JPasswordField tfNewPassFP;
    JTextField tfPhoneFP;
    // End of variables declaration
    public ForgetPassword(DataOutputStream dos) {
        mDOS=dos;
        //setLocationRelativeTo(Client.this);
        initComponents();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 400);
        jLabelConfirmPassFP.setVisible(false);
        jLabelNewPassFP.setVisible(false);
        jLabelAnsFP.setVisible(false);
        jLabelQuesFP.setVisible(false);
        tfAnsFP.setVisible(false);
        tfNewPassFP.setVisible(false);
        tfConfirmPassFP.setVisible(false);
        btChangePassFP.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelForgetFP = new JLabel();
        jLabelPhoneFP = new JLabel();
        jLabelQuesFP = new JLabel();
        jLabelNewPassFP = new JLabel();
        jLabelConfirmPassFP = new JLabel();
        btChangePassFP = new JButton();
        tfPhoneFP = new JTextField();
        tfConfirmPassFP = new JPasswordField();
        tfAnsFP = new JPasswordField();
        tfNewPassFP = new JPasswordField();
        jLabelAnsFP = new JLabel();
        lbQuestionFP = new JLabel();
        btNextFP = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelForgetFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelForgetFP.setText("FORGET PASSWORD");
        getContentPane().add(jLabelForgetFP);
        jLabelForgetFP.setBounds(110, 10, 140, 14);

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

        btChangePassFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btChangePassFP.setText("SUBMIT");
        btChangePassFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePassFPActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePassFP);
        btChangePassFP.setBounds(140, 270, 80, 23);
        getContentPane().add(tfPhoneFP);
        tfPhoneFP.setBounds(150, 50, 140, 30);
        getContentPane().add(tfConfirmPassFP);
        tfConfirmPassFP.setBounds(150, 230, 140, 30);
        getContentPane().add(tfAnsFP);
        tfAnsFP.setBounds(150, 150, 140, 30);
        getContentPane().add(tfNewPassFP);
        tfNewPassFP.setBounds(150, 190, 140, 30);

        jLabelAnsFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAnsFP.setText("Security Ans.");
        getContentPane().add(jLabelAnsFP);
        jLabelAnsFP.setBounds(10, 140, 90, 30);
        getContentPane().add(lbQuestionFP);
        lbQuestionFP.setBounds(150, 90, 250, 50);

        btNextFP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btNextFP.setText("NEXT");
        btNextFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextFPActionPerformed(evt);
            }
        });
        getContentPane().add(btNextFP);
        btNextFP.setBounds(300, 50, 70, 30);

        pack();
    }// </editor-fold>

    private void btChangePassFPActionPerformed(java.awt.event.ActionEvent evt) {
        String phone, pass, newPass, confirmPass;
        phone = tfPhoneFP.getText();
        pass = tfAnsFP.getText();
        newPass = tfNewPassFP.getText();
        confirmPass = tfConfirmPassFP.getText();
        if (phone.isEmpty() || pass.isEmpty() || newPass.isEmpty() || (confirmPass.equals(""))) {
            JOptionPane.showMessageDialog(this, "All Fields are compulsary");
        } else if (!newPass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(this, "Confirm password is different");
        } else {
            try {
                mDOS.writeBytes("forgetpass\r\n");
                mDOS.writeBytes(phone + "\r\n");
                mDOS.writeBytes(pass + "\r\n");
                mDOS.writeBytes(newPass + "\r\n");//*/
            } catch (Exception ex) {
                System.out.println("forget password fail"+ex.getMessage());
            }

        }
    }

    private void btNextFPActionPerformed(java.awt.event.ActionEvent evt) {
        String pno = tfPhoneFP.getText();
        if (pno.length() < 10) {
            JOptionPane.showMessageDialog(this, "Phone no. should be of 10 digit");
        } else {
            try {
                mDOS.writeBytes("forgetnext\r\n");
                mDOS.writeBytes(pno + "\r\n");//*/
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
