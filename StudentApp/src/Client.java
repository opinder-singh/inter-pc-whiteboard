import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

public class Client extends javax.swing.JFrame {
    ChangePassword mChangePassword;
    ForgetPassword mForgetPassword;
    //int lol=0, ncon = 0;
    boolean isErrorOccured=false;
    DataOutputStream mDOS;
    DataInputStream mDIS;
    StudentSignup mStudentSignup;
    StudentLogin mStudentLogin;
    StudentDiscussion mStudentDiscussion;
    String text = "";
    ArrayList<Drawing> alDrawing = new ArrayList<>();
    WhiteBoard mWhiteBoard;

    public Client() {
        initComponents();
        setResizable(false);
        setSize(350, 400);
        setLocation(500, 100);
        setTitle("STUDENT");
        btSignUp.setEnabled(false);
        btLogin.setEnabled(false);
        btForgetPass.setEnabled(false);
        btChangePass.setEnabled(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void openMain() {
        this.setVisible(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfIPAddress = new javax.swing.JTextField();
        btConnection = new javax.swing.JButton();
        btSignUp = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        lableIPAddress = new javax.swing.JLabel();
        btExit = new javax.swing.JButton();
        btChangePass = new javax.swing.JButton();
        btForgetPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tfIPAddress);
        tfIPAddress.setBounds(10, 30, 130, 30);

        btConnection.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btConnection.setText("Connect to Server");
        btConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectActionPerformed(evt);
            }
        });
        getContentPane().add(btConnection);
        btConnection.setBounds(150, 30, 160, 30);
        btConnection.setEnabled(true);

        btSignUp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSignUp.setText("STUDENT SIGNUP");
        btSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });
        getContentPane().add(btSignUp);
        btSignUp.setBounds(10, 100, 140, 30);

        btLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btLogin.setText("STUDENT LOGIN");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btLogin);
        btLogin.setBounds(170, 100, 140, 30);

        lableIPAddress.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lableIPAddress.setText("IP Address");
        getContentPane().add(lableIPAddress);
        lableIPAddress.setBounds(50, 10, 70, 20);

        btExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExit.setText("EXIT");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        getContentPane().add(btExit);
        btExit.setBounds(110, 220, 100, 30);

        btChangePass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btChangePass.setText("CHANGE PASS.");
        btChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePassActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePass);
        btChangePass.setBounds(10, 150, 140, 30);

        btForgetPass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btForgetPass.setText("FORGET PASS.");
        btForgetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btForgetPassActionPerformed(evt);
            }
        });
        getContentPane().add(btForgetPass);
        btForgetPass.setBounds(170, 150, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt) {
        if (btConnection.isEnabled()) {
            //ncon = 0;
            isErrorOccured=false;
            Inner obj = new Inner();
            Thread t1 = new Thread(obj);
            t1.start();

        } else {
            JOptionPane.showMessageDialog(this, "ALREADY CONNECTED ");
        }
    }

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {
        mStudentSignup = new StudentSignup(mDOS);
        mStudentSignup.setLocationRelativeTo(this);
    }

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {
        mStudentLogin = new StudentLogin(mDOS);
        mStudentLogin.setLocationRelativeTo(this);
    }

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {
        int exi = JOptionPane.showConfirmDialog(this, "Are you sure to EXIT", "EXIT", JOptionPane.YES_NO_OPTION);
        if (exi == 0) {
            System.exit(0);
        }
    }

    private void btChangePassActionPerformed(java.awt.event.ActionEvent evt) {
        mChangePassword = new ChangePassword(mDOS);
        mChangePassword.setLocationRelativeTo(this);
    }

    private void btForgetPassActionPerformed(java.awt.event.ActionEvent evt) {
        mForgetPassword = new ForgetPassword(mDOS);
        mForgetPassword.setLocationRelativeTo(this);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConnection;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btForgetPass;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSignUp;
    private javax.swing.JButton btChangePass;
    private javax.swing.JLabel lableIPAddress;
    private javax.swing.JTextField tfIPAddress;
    // End of variables declaration//GEN-END:variables

    class Inner implements Runnable {

        String response;
        public Inner() {
            try {
                String ipaddress = tfIPAddress.getText();
                Socket sock = new Socket(ipaddress, 9000);
                mDIS = new DataInputStream(sock.getInputStream());
                mDOS = new DataOutputStream(sock.getOutputStream());
                btConnection.setText("CONNECTED");
                btConnection.setBackground(Color.red);
                tfIPAddress.setFocusable(false);
                btSignUp.setEnabled(true);
                btLogin.setEnabled(true);
                btForgetPass.setEnabled(true);
                btChangePass.setEnabled(true);
                FileReceiverServer fileReceiverServer = new FileReceiverServer();
                Thread thread = new Thread(fileReceiverServer);
                thread.start();
                btConnection.setEnabled(false);
                //lol++;
            } catch (Exception ex) {
                tfIPAddress.setText("INVALID IP");
                isErrorOccured=true;
                //ncon = 5;
            }
        }

        public void run() {
            try {
                if (!isErrorOccured) {
                    while (true) {
                        response = mDIS.readLine();
                        if (response.equals("signup_true")) {
                            JOptionPane.showMessageDialog(mStudentSignup, "Signup Successful");
                            mStudentSignup.setVisible(false);
                            openMain();
                        } else if (response.equals("signup_false")) {
                            JOptionPane.showMessageDialog(mStudentSignup, "Signup Failed");
                        } else if (response.equals("login_false")) {
                            JOptionPane.showMessageDialog(mStudentLogin, "Login Failed");
                        } else if (response.equals("changetrue")) {
                            JOptionPane.showMessageDialog(mChangePassword, "Password changed");
                        } else if (response.equals("changefalse")) {
                            JOptionPane.showMessageDialog(mChangePassword, "Invalid User");
                        } else if (response.equals("forgettrue")) {
                            JOptionPane.showMessageDialog(mForgetPassword, "Password changed");
                            mForgetPassword.setVisible(false);
                        } else if (response.equals("forgetfalse")) {
                            JOptionPane.showMessageDialog(mForgetPassword, "Invalid User");
                        } else if (response.equals("forgetques")) {
                            String nam = mDIS.readLine();
                            mForgetPassword.jLabelConfirmPassFP.setVisible(true);
                            mForgetPassword.jLabelNewPassFP.setVisible(true);
                            mForgetPassword.jLabelAnsFP.setVisible(true);
                            mForgetPassword.jLabelQuesFP.setVisible(true);
                            mForgetPassword.tfAnsFP.setVisible(true);
                            mForgetPassword.tfNewPassFP.setVisible(true);
                            mForgetPassword.tfConfirmPassFP.setVisible(true);
                            mForgetPassword.btChangePassFP.setVisible(true);
                            mForgetPassword.lbQuestionFP.setText(nam + "  ?");

                        } else if (response.equals("forgetnodata")) {
                            JOptionPane.showMessageDialog(mForgetPassword, "Invalid User");
                        } else if (response.equals("login_true")) {
                            JOptionPane.showMessageDialog(mStudentLogin, "Login Successfull");
                            mStudentLogin.btLoginSL.setEnabled(false);
                            btLogin.setEnabled(false);
                            mStudentLogin.setVisible(false);
                        } else if (response.equals("message")) {
                            String teacherName = mDIS.readLine();
                            String message = mDIS.readLine();
                            if (mStudentDiscussion == null) {
                                mStudentDiscussion = new StudentDiscussion(mDOS);
                                mStudentDiscussion.setLocationRelativeTo(Client.this);
                            }
                            mStudentDiscussion.setVisible(true);
                            mStudentDiscussion.textArea_message_history_SD.append(teacherName + "  Sir : " + message + "\n");
                        } else if (response.equals("drawing")) {
                            if (mWhiteBoard == null) {
                                mWhiteBoard = new WhiteBoard(alDrawing);
                                mWhiteBoard.setLocationRelativeTo(Client.this);
                            }
                            if (!mWhiteBoard.isVisible()) {
                                mWhiteBoard.setVisible(true);
                            }
                            alDrawing.clear();
                            int size = mDIS.readInt();
                            for (int i = 0; i < size; i++) {
                                String shapeType = mDIS.readLine();
                                int startingX = mDIS.readInt();
                                int startingY = mDIS.readInt();
                                int endingX = mDIS.readInt();
                                int endingY = mDIS.readInt();
                                int red = mDIS.readInt();
                                int green = mDIS.readInt();
                                int blue = mDIS.readInt();
                                int stroke = mDIS.readInt();
                                boolean isSolid = mDIS.readBoolean();
                                text = mDIS.readLine();
                                alDrawing.add(new Drawing(shapeType, startingX, startingY, endingX, endingY, new Color(red, green, blue), stroke, isSolid, text));
                            }
                            mWhiteBoard.repaint();
                        }

                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Client.this, "  Teacher Exited ");
                btLogin.setEnabled(true);
                tfIPAddress.setFocusable(true);
                btConnection.setText("Connect to Server");
                btConnection.setEnabled(true);
                //lol = 0;
            }
        }
    }
}