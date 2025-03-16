import javax.swing.*;
import java.io.DataOutputStream;

public class ChangePassword extends JFrame {
    DataOutputStream mDOS=null;
    public ChangePassword(DataOutputStream dos) {
        mDOS=dos;
        //setLocationRelativeTo(Client.this);
        initComponents();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 350);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLabel1cp = new JLabel();
        jLabel2cp = new JLabel();
        jLabel3cp = new JLabel();
        jLabel4cp = new JLabel();
        jLabel5cp = new JLabel();
        btChangePassCP = new JButton();
        tfPhoneCP = new JTextField();
        tfConfirmCP = new JPasswordField();
        tfOldPassCP = new JPasswordField();
        tfNewPassCP = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1cp.setText("CHANGE PASSWORD");
        getContentPane().add(jLabel1cp);
        jLabel1cp.setBounds(110, 10, 140, 14);

        jLabel2cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2cp.setText("Phone No.");
        getContentPane().add(jLabel2cp);
        jLabel2cp.setBounds(10, 60, 80, 15);

        jLabel3cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3cp.setText("Password");
        getContentPane().add(jLabel3cp);
        jLabel3cp.setBounds(10, 100, 70, 15);

        jLabel4cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4cp.setText("New password");
        getContentPane().add(jLabel4cp);
        jLabel4cp.setBounds(10, 140, 100, 15);

        jLabel5cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5cp.setText("Confirm pass.");
        getContentPane().add(jLabel5cp);
        jLabel5cp.setBounds(10, 180, 110, 15);

        btChangePassCP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btChangePassCP.setText("SUBMIT");
        btChangePassCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePassCPActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePassCP);
        btChangePassCP.setBounds(140, 230, 80, 23);
        getContentPane().add(tfPhoneCP);
        tfPhoneCP.setBounds(150, 50, 140, 30);
        getContentPane().add(tfConfirmCP);
        tfConfirmCP.setBounds(150, 180, 140, 30);
        getContentPane().add(tfOldPassCP);
        tfOldPassCP.setBounds(150, 100, 140, 30);
        getContentPane().add(tfNewPassCP);
        tfNewPassCP.setBounds(150, 140, 140, 30);
        pack();
    }// </editor-fold>

    private void btChangePassCPActionPerformed(java.awt.event.ActionEvent evt) {
        String phone, oldPass, newPass, confirmPass;

        phone = tfPhoneCP.getText();
        oldPass = tfOldPassCP.getText();
        newPass = tfNewPassCP.getText();
        confirmPass = tfConfirmCP.getText();

        if (phone.equals("") || oldPass.equals("") || newPass.equals("") || (confirmPass.equals(""))) {
            JOptionPane.showMessageDialog(this, "All Fields are compulsary");
        } else if (phone.length() != 10) {
            JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
        } else if (!newPass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(this, "Confirm password is different");
        } else {
            try {
                mDOS.writeBytes("changepass\r\n");
                mDOS.writeBytes(phone + "\r\n");
                mDOS.writeBytes(oldPass + "\r\n");
                mDOS.writeBytes(newPass + "\r\n");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private JButton btChangePassCP;
    private JLabel jLabel1cp;
    private JLabel jLabel2cp;
    private JLabel jLabel3cp;
    private JLabel jLabel4cp;
    private JLabel jLabel5cp;
    private JPasswordField tfConfirmCP;
    private JPasswordField tfNewPassCP;
    private JPasswordField tfOldPassCP;
    private JTextField tfPhoneCP;
}
