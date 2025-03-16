import javax.swing.*;
import java.io.DataOutputStream;

public class StudentSignup extends javax.swing.JFrame {
DataOutputStream mDOS=null;
        public StudentSignup(DataOutputStream dos) {
            //setLocationRelativeTo(Client.this);
            setTitle("STUDENT SIGN-UP");
            initComponents();
            setResizable(false);
            setVisible(true);
            setSize(450, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mDOS=dos;
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            btSignUpSS = new javax.swing.JButton();
            jLabelPhoneSS = new javax.swing.JLabel();
            jLabelEmailSS = new javax.swing.JLabel();
            jLabelPassSS = new javax.swing.JLabel();
            jLabelQuesSS = new javax.swing.JLabel();
            jLabelAnsSS = new javax.swing.JLabel();
            jLabelNameSS = new javax.swing.JLabel();
            tfNameSS = new javax.swing.JTextField();
            tfPhoneSS = new javax.swing.JTextField();
            tfEmailSS = new javax.swing.JTextField();
            tfQuesSS = new javax.swing.JTextField();
            tfAnsSS = new javax.swing.JTextField();
            tfPassSS = new javax.swing.JPasswordField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);

            btSignUpSS.setText("SIGN UP");
            btSignUpSS.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btSignUpSSActionPerformed(evt);
                }
            });
            getContentPane().add(btSignUpSS);
            btSignUpSS.setBounds(170, 420, 100, 30);

            jLabelPhoneSS.setText("MOBILE NO.");
            getContentPane().add(jLabelPhoneSS);
            jLabelPhoneSS.setBounds(15, 90, 100, 20);

            jLabelEmailSS.setText("EMAIL");
            getContentPane().add(jLabelEmailSS);
            jLabelEmailSS.setBounds(15, 150, 40, 20);

            jLabelPassSS.setText("PASSWORD");
            getContentPane().add(jLabelPassSS);
            jLabelPassSS.setBounds(15, 210, 100, 14);

            jLabelQuesSS.setText("SECURITY QUST.");
            getContentPane().add(jLabelQuesSS);
            jLabelQuesSS.setBounds(15, 275, 100, 14);

            jLabelAnsSS.setText("SECURITY ANS.");
            getContentPane().add(jLabelAnsSS);
            jLabelAnsSS.setBounds(15, 340, 100, 20);

            jLabelNameSS.setText("NAME");
            getContentPane().add(jLabelNameSS);
            jLabelNameSS.setBounds(15, 40, 40, 14);
            getContentPane().add(tfNameSS);
            tfNameSS.setBounds(130, 40, 240, 30);
            getContentPane().add(tfPhoneSS);
            tfPhoneSS.setBounds(130, 90, 240, 30);
            getContentPane().add(tfEmailSS);
            tfEmailSS.setBounds(130, 150, 240, 30);
            getContentPane().add(tfQuesSS);
            tfQuesSS.setBounds(130, 270, 240, 30);
            getContentPane().add(tfAnsSS);
            tfAnsSS.setBounds(130, 340, 240, 30);
            getContentPane().add(tfPassSS);
            tfPassSS.setBounds(130, 210, 240, 30);

            pack();
        }// </editor-fold>                        

        private void btSignUpSSActionPerformed(java.awt.event.ActionEvent evt) {
            String name = tfNameSS.getText();
            String email = tfEmailSS.getText();
            String mob = tfPhoneSS.getText();
            String secQues = tfQuesSS.getText();
            String secAns = tfAnsSS.getText();
            String password = tfPassSS.getText();
            if (name.equals("") || mob.equals("") || email.equals("") || secQues.equals("") || secAns.equals("") || (password.equals(""))) {
                JOptionPane.showMessageDialog(this, "All Fields are compulsary");
            } else if (mob.length() != 10) {
                JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
            } else {
                try {
                    mDOS.writeBytes("student_signup\r\n"); //requset
                    mDOS.writeBytes(name + "\r\n");
                    mDOS.writeBytes(email + "\r\n");
                    mDOS.writeBytes(mob + "\r\n");
                    mDOS.writeBytes(secQues + "\r\n");
                    mDOS.writeBytes(secAns + "\r\n");
                    mDOS.writeBytes(password + "\r\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }

        // Variables declaration - do not modify                     
        private javax.swing.JLabel jLabelEmailSS;
        private javax.swing.JLabel jLabelPassSS;
        private javax.swing.JLabel jLabelQuesSS;
        private javax.swing.JLabel jLabelAnsSS;
        private javax.swing.JLabel jLabelPhoneSS;
        private javax.swing.JLabel jLabelNameSS;
        private javax.swing.JButton btSignUpSS;
        private javax.swing.JTextField tfEmailSS;
        private javax.swing.JTextField tfPhoneSS;
        private javax.swing.JTextField tfNameSS;
        private javax.swing.JPasswordField tfPassSS;
        private javax.swing.JTextField tfAnsSS;
        private javax.swing.JTextField tfQuesSS;
        // End of variables declaration                   
    }
