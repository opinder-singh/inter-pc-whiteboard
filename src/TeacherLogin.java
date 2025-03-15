import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherLogin extends JFrame {
    public String teachername;
    Server mServer;

    public TeacherLogin(Server server) {
        initComponents();
        //setLocationRelativeTo(Server.this);
        setResizable(false);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        mServer = server;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelPhoneTL = new JLabel();
        jLabelPassTL = new JLabel();
        pfPasswordTL = new JPasswordField();
        tfPhoneTL = new JTextField();
        jLabelTeacherLoginTL = new JLabel();
        btTeacherLoginTL = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelPhoneTL.setText("MOBILE NO.");
        getContentPane().add(jLabelPhoneTL);
        jLabelPhoneTL.setBounds(40, 76, 74, 14);

        jLabelPassTL.setText("PASSWORD");
        getContentPane().add(jLabelPassTL);
        jLabelPassTL.setBounds(40, 127, 62, 14);
        getContentPane().add(pfPasswordTL);
        pfPasswordTL.setBounds(152, 124, 160, 30);
        getContentPane().add(tfPhoneTL);
        tfPhoneTL.setBounds(152, 73, 160, 30);

        jLabelTeacherLoginTL.setForeground(new java.awt.Color(250, 0, 0));
        jLabelTeacherLoginTL.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabelTeacherLoginTL.setText("TEACHER LOGIN ");
        getContentPane().add(jLabelTeacherLoginTL);
        jLabelTeacherLoginTL.setBounds(115, 10, 150, 30);

        btTeacherLoginTL.setText("LOGIN");
        btTeacherLoginTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTeacherLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btTeacherLoginTL);
        btTeacherLoginTL.setBounds(110, 250, 140, 40);

        pack();
    }// </editor-fold>

    private void btTeacherLoginActionPerformed(java.awt.event.ActionEvent evt) {
        try {

            String mob = tfPhoneTL.getText();
            String pass = new String(pfPasswordTL.getPassword());
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + mob + "'and password = '" + pass + "'");
            if (rs.next()) {
                teachername = rs.getString("name");
                JOptionPane.showMessageDialog(this, "Login Successful");
                btTeacherLoginTL.setEnabled(false);
                mServer.teacherName = teachername;
                mServer.setTitle("Admin :" + teachername);
                //btlogin.setEnabled(false);
                this.setVisible(false);
                //openmain();

            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify
    private JLabel jLabelPhoneTL;
    private JLabel jLabelPassTL;
    private JLabel jLabelTeacherLoginTL;
    private JPasswordField pfPasswordTL;
    private JButton btTeacherLoginTL;
    private JTextField tfPhoneTL;
    // End of variables declaration
}
