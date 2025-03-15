import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherSignUp extends JFrame {

    public TeacherSignUp() {
        initComponents();
        //setLocationRelativeTo(Server.this);
        setResizable(false);
        setSize(400, 600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelSignUpTS = new JLabel();
        tfEmailTS = new JTextField();
        tfNameTS = new JTextField();
        btSignUpTS = new JButton();
        jLabelPassTS = new JLabel();
        jLabelEmailTS = new JLabel();
        jLabelPhoneTS = new JLabel();
        jLabelNameTS = new JLabel();
        tfPasswordTS = new JPasswordField();
        tfQuesTs = new JTextField();
        tfAnsTs = new JTextField();
        jLabelQuesTS = new JLabel();
        jLabelAnsTS = new JLabel();
        tfPhoneTS = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelSignUpTS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSignUpTS.setText("Signup");
        getContentPane().add(jLabelSignUpTS);
        jLabelSignUpTS.setBounds(170, 20, 120, 30);
        getContentPane().add(tfEmailTS);
        tfEmailTS.setBounds(110, 190, 220, 30);
        getContentPane().add(tfNameTS);
        tfNameTS.setBounds(110, 90, 220, 30);

        btSignUpTS.setText("Sign Up");
        btSignUpTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btSignUpTS);
        btSignUpTS.setBounds(150, 400, 140, 40);

        jLabelPassTS.setText("Password");
        getContentPane().add(jLabelPassTS);
        jLabelPassTS.setBounds(10, 240, 90, 20);

        jLabelEmailTS.setText("e-mail");
        getContentPane().add(jLabelEmailTS);
        jLabelEmailTS.setBounds(10, 190, 90, 20);

        jLabelPhoneTS.setText("Phone-No.");
        getContentPane().add(jLabelPhoneTS);
        jLabelPhoneTS.setBounds(10, 140, 70, 20);

        jLabelNameTS.setText("Name");
        getContentPane().add(jLabelNameTS);
        jLabelNameTS.setBounds(14, 94, 70, 20);
        getContentPane().add(tfPasswordTS);
        tfPasswordTS.setBounds(110, 240, 220, 30);

        getContentPane().add(tfQuesTs);
        tfQuesTs.setBounds(110, 290, 220, 30);
        getContentPane().add(tfAnsTs);
        tfAnsTs.setBounds(110, 340, 220, 30);

        jLabelQuesTS.setText("Security Ques.");
        getContentPane().add(jLabelQuesTS);
        jLabelQuesTS.setBounds(10, 290, 80, 20);

        jLabelAnsTS.setText("Security Ans.");
        getContentPane().add(jLabelAnsTS);
        jLabelAnsTS.setBounds(10, 340, 90, 20);
        getContentPane().add(tfPhoneTS);
        tfPhoneTS.setBounds(110, 140, 220, 30);

        pack();
    }// </editor-fold>

    private void btSignUpActionPerformed(java.awt.event.ActionEvent evt) {
        String name, phone, email, password, ques, ans;

        name = tfNameTS.getText();
        phone = tfPhoneTS.getText();
        email = tfEmailTS.getText();
        password = tfPasswordTS.getText();
        ques = tfQuesTs.getText();
        ans = tfAnsTs.getText();

        if (name.equals("") || phone.equals("") || email.equals("") || ques.equals("") || ans.equals("") || (password.equals(""))) {
            JOptionPane.showMessageDialog(this, "All Fields are compulsary");
        } else if (phone.length() != 10) {
            JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
        } else {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from teacher");
                String a = tfNameTS.getText();
                String b = tfPhoneTS.getText();
                String c = tfEmailTS.getText();
                String d = tfPasswordTS.getText();
                String e = tfQuesTs.getText();
                String f = tfAnsTs.getText();

                rs.moveToInsertRow();
                rs.updateString("Name", a);
                rs.updateString("Mobile_no", b);
                rs.updateString("email", c);
                rs.updateString("Password", d);
                rs.updateString("seq_ques", e);
                rs.updateString("seq_ans", f);
                rs.insertRow();

                rs.close();
                stmt.close();
                con.close();
                JOptionPane.showMessageDialog(this, "Sign up Successful");
                tfNameTS.setText("");
                tfPhoneTS.setText("");
                tfEmailTS.setText("");
                tfPasswordTS.setText("");
                tfQuesTs.setText("");
                tfAnsTs.setText("");
                this.setVisible(false);
                //openmain();

            } catch (Exception ex) {
                if (ex.toString().toLowerCase().contains("duplicate entry")) {
                    JOptionPane.showMessageDialog(this, "Phone Already Registered");
                } else {
                    JOptionPane.showMessageDialog(this, "Sign-up failed.Please try again.");
                }
            }

        }
    }

    private JLabel jLabelEmailTS;
    private JLabel jLabelSignUpTS;
    private JLabel jLabelNameTS;
    private JLabel jLabelPassTS;
    private JLabel jLabelPhoneTS;
    private JButton btSignUpTS;
    private JLabel jLabelQuesTS;
    private JLabel jLabelAnsTS;
    private JTextField tfEmailTS;
    private JTextField tfPhoneTS;
    private JTextField tfNameTS;
    private JPasswordField tfPasswordTS;
    private JTextField tfAnsTs;
    private JTextField tfQuesTs;
    // End of variables declaration
}