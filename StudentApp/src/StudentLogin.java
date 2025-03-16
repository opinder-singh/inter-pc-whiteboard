import java.io.DataOutputStream;

public class StudentLogin extends javax.swing.JFrame {
    DataOutputStream mDOS = null;
    public StudentLogin(DataOutputStream dos) {
        //setLocationRelativeTo(Client.this);
        mDOS = dos;
        initComponents();
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Student Login");
        setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelPhoneSL = new javax.swing.JLabel();
        jLabelPassSL = new javax.swing.JLabel();
        tfPassSL = new javax.swing.JPasswordField();
        tfPhoneSL = new javax.swing.JTextField();
        jLabelLoginSL = new javax.swing.JLabel();
        btLoginSL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelPhoneSL.setText("MOBILE NO.");
        getContentPane().add(jLabelPhoneSL);
        jLabelPhoneSL.setBounds(40, 76, 74, 14);

        jLabelPassSL.setText("PASSWORD");
        getContentPane().add(jLabelPassSL);
        jLabelPassSL.setBounds(40, 127, 62, 14);
        getContentPane().add(tfPassSL);
        tfPassSL.setBounds(132, 124, 160, 30);
        getContentPane().add(tfPhoneSL);
        tfPhoneSL.setBounds(132, 73, 160, 30);

        jLabelLoginSL.setForeground(new java.awt.Color(0, 0, 250));
        jLabelLoginSL.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabelLoginSL.setText("Student Login ");
        getContentPane().add(jLabelLoginSL);
        jLabelLoginSL.setBounds(115, 10, 150, 30);

        btLoginSL.setText("LOGIN");
        btLoginSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSloginActionPerformed(evt);
            }
        });
        getContentPane().add(btLoginSL);
        btLoginSL.setBounds(110, 250, 140, 40);
        pack();
    }// </editor-fold>

    private void btSloginActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String mo = tfPhoneSL.getText();
            String pa = tfPassSL.getText();
            mDOS.writeBytes("student_login\r\n"); //requset
            mDOS.writeBytes(mo + "\r\n");
            mDOS.writeBytes(pa + "\r\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify
    javax.swing.JButton btLoginSL;
    private javax.swing.JLabel jLabelPhoneSL;
    private javax.swing.JLabel jLabelPassSL;
    private javax.swing.JLabel jLabelLoginSL;
    private javax.swing.JTextField tfPhoneSL;
    private javax.swing.JPasswordField tfPassSL;
    // End of variables declaration
}
