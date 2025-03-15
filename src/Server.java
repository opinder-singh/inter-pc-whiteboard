import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Server extends JFrame {

    ChangePassword mChangePassword;
    ForgetPassword mForgetPassword;
    ArrayList<ClientHandler> alStudent = new ArrayList<>();
    StudentTableModel tableModel;
    TeacherDiscussion discussion;
    String teacherName;
    WhiteBoard mWhiteBoard;
    int fileSentValue = 0;
    FileProgressBar progressBar;

    // Below Variable are defined and used for Drawing purpose
    ArrayList<Drawing> alDrawing = new ArrayList<>();
    String drawingType = "freehand";
    Color selectedColor = Color.BLACK;
    int stroke = 1;
    boolean isSolid = false;
    String text = "";
    int startXRect = 0;
    int startYRect = 0;
    int heightRect = 0;
    int widthRect = 0;
    SelectShape selectShape = new SelectShape();
    int textX = 0;
    int textY = 0;
    //End of Variables for Drawing purpose

    public Server() {
        setVisible(true);
        setResizable(false);
        setTitle("    Admin ");
        tableModel = new StudentTableModel();
        initComponents();
        btSignUp.setEnabled(false);
        btLogin.setEnabled(false);
        btChangePassword.setEnabled(false);
        btForgetPassword.setEnabled(false);
        btStartDiscussion.setEnabled(false);
        btnWhiteBoard.setEnabled(false);
        btSendFile.setEnabled(false);
        setSize(500, 425);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mjTable.setModel(tableModel);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btStartServer = new JButton();
        btSignUp = new JButton();
        btLogin = new JButton();
        jScrollPane1 = new JScrollPane();
        mjTable = new JTable();
        jLabelConnectedStudents = new JLabel();
        btStartDiscussion = new JButton();
        btSendFile = new JButton();
        btExit = new JButton();
        btnWhiteBoard = new JButton();
        btChangePassword = new JButton();
        btForgetPassword = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocation(50, 50);

        btStartServer.setFont(new Font("Arial", 1, 12)); // NOI18N
        btStartServer.setText("START SERVER");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });
        getContentPane().add(btStartServer);
        btStartServer.setBounds(10, 10, 170, 40);

        btSignUp.setFont(new Font("Arial", 1, 12)); // NOI18N
        btSignUp.setText("SIGN UP");
        btSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btSignUp);
        btSignUp.setBounds(10, 70, 82, 30);

        btLogin.setFont(new Font("Arial", 1, 12)); // NOI18N
        btLogin.setText("LOGIN ");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btLogin);
        btLogin.setBounds(100, 70, 80, 30);

        mjTable.setBackground(new Color(244, 244, 244));
        mjTable.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "NAME", "Student IP"
                }
        ));
        mjTable.setToolTipText("");
        mjTable.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(mjTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 30, 220, 320);

        jLabelConnectedStudents.setFont(new Font("Arial", 1, 12)); // NOI18N
        jLabelConnectedStudents.setText("CONNECTED STUDENTS");
        getContentPane().add(jLabelConnectedStudents);
        jLabelConnectedStudents.setBounds(280, 10, 150, 15);

        btStartDiscussion.setFont(new Font("Arial", 1, 12)); // NOI18N
        btStartDiscussion.setText("START DISCUSSION");
        btStartDiscussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartDiscussionActionPerformed(evt);
            }
        });
        getContentPane().add(btStartDiscussion);
        btStartDiscussion.setBounds(10, 190, 170, 30);

        btSendFile.setFont(new Font("Arial", 1, 12)); // NOI18N
        btSendFile.setText("SEND FILE");
        btSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendFileActionPerformed(evt);
            }
        });
        getContentPane().add(btSendFile);
        btSendFile.setBounds(10, 270, 170, 30);

        btExit.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        btExit.setText("EXIT");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        getContentPane().add(btExit);
        btExit.setBounds(50, 310, 90, 23);

        btnWhiteBoard.setFont(new Font("Arial", 1, 12)); // NOI18N
        btnWhiteBoard.setText("START WHITEBOARD");
        btnWhiteBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWhiteBoardActionPerformed(evt);
            }
        });
        getContentPane().add(btnWhiteBoard);
        btnWhiteBoard.setBounds(10, 230, 170, 30);

        btChangePassword.setFont(new Font("Arial", 1, 12)); // NOI18N
        btChangePassword.setText("CHANGE PASSWORD");
        btChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePassword);
        btChangePassword.setBounds(10, 110, 170, 30);

        btForgetPassword.setFont(new Font("Arial", 1, 12)); // NOI18N
        btForgetPassword.setText("FORGET PASSWORD");
        btForgetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btForgetPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btForgetPassword);
        btForgetPassword.setBounds(10, 150, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadMySqlDriverManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Database connection Manager not found");
        }
    }

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {
        btSignUp.setEnabled(true);
        btLogin.setEnabled(true);
        btChangePassword.setEnabled(true);
        btForgetPassword.setEnabled(true);
        btStartDiscussion.setEnabled(true);
        btnWhiteBoard.setEnabled(true);
        btSendFile.setEnabled(true);
        btStartServer.setBackground(Color.red);
        loadMySqlDriverManager();
        try {
            Inner obj = new Inner();
            Thread t2 = new Thread(obj);
            t2.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void btSignUpActionPerformed(java.awt.event.ActionEvent evt) {

        TeacherSignUp tea = new TeacherSignUp();
        tea.setLocationRelativeTo(this);
        tea.setTitle("Sign up");

    }

    public void openMain() {
        this.setVisible(true);

    }

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {
        TeacherLogin login = new TeacherLogin(this);
        login.setLocationRelativeTo(this);
    }

    private void btStartDiscussionActionPerformed(java.awt.event.ActionEvent evt) {
        if (true || teacherName != null) {
            discussion = new TeacherDiscussion(alStudent, teacherName);
            discussion.setLocationRelativeTo(this);
            discussion.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Login Required ");
        }
    }

    private void btSendFileActionPerformed(java.awt.event.ActionEvent evt) {
        fileSentValue = 0;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select File to Send");
        int n = chooser.showOpenDialog(this);
        if (n == 0) {
            if (alStudent.isEmpty()) {
                return;
            }
            btSendFile.setEnabled(false);
            File selectedFile = chooser.getSelectedFile();
            progressBar = new FileProgressBar(selectedFile.getName(), alStudent.size());
            progressBar.setLocationRelativeTo(this);
            for (int i = 0; i < alStudent.size(); i++) {
                String IP = alStudent.get(i).sock.getInetAddress().toString().substring(1);
                FileSendingClient client = new FileSendingClient(IP, selectedFile, this);
                Thread thread = new Thread(client);
                thread.start();
            }
        }
    }

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {
        int exi = JOptionPane.showConfirmDialog(this, "Are you sure to EXIT", "EXIT", JOptionPane.YES_NO_OPTION);
        if (exi == 0) {
            System.exit(0);
        }
    }

    private void btWhiteBoardActionPerformed(java.awt.event.ActionEvent evt) {
        if (mWhiteBoard == null) {
            mWhiteBoard = new WhiteBoard(alStudent);
            mWhiteBoard.setLocationRelativeTo(this);
        } else {
            mWhiteBoard.setVisible(true);
        }

    }

    private void btChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        mChangePassword = new ChangePassword();
        mChangePassword.setLocationRelativeTo(this);
    }

    private void btForgetPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        mForgetPassword = new ForgetPassword();
        mForgetPassword.setLocationRelativeTo(this);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btStartServer;
    private JButton btChangePassword;
    private JButton btForgetPassword;
    private JButton btLogin;
    private JButton btnWhiteBoard;
    private JButton btExit;
    JButton btSendFile;
    private JButton btSignUp;
    private JButton btStartDiscussion;
    private JLabel jLabelConnectedStudents;
    private JScrollPane jScrollPane1;
    private JTable mjTable;
    // End of variables declaration//GEN-END:variables

    class Inner implements Runnable {

        public void run() {
            try {
                ServerSocket sersock = new ServerSocket(9000);
                btStartServer.setText("SERVER STARTED");
                System.out.println("Server is Started at 9000");
                while (true) {
                    Socket sock = sersock.accept();
                    System.out.println("Connection Accepted");
                    ClientHandler cl = new ClientHandler(sock);
                    Thread t1 = new Thread(cl);
                    t1.start();
                }
            } catch (Exception e) {
                if (e.toString().toLowerCase().contains("already in use")) {
                    JOptionPane.showMessageDialog(Server.this, "Server Already Working ");
                }
            }
        }
    }

    class ClientHandler implements Runnable {

        String studentName;
        Socket sock;
        String request;
        DataInputStream dis;
        DataOutputStream dos;

        ClientHandler(Socket sock) {
            try {
                this.sock = sock;
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                while (true) {
                    request = dis.readLine();
                    if (request.equals("student_signup")) {
                        String name = dis.readLine();
                        String email = dis.readLine();
                        String mob = dis.readLine();
                        String secQues = dis.readLine();
                        String secAns = dis.readLine();
                        String password = dis.readLine();

                        try {
                            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("select * from student");
                            rs.moveToInsertRow();
                            rs.updateString("name", name);
                            rs.updateString("phone", mob);
                            rs.updateString("email", email);
                            rs.updateString("sec_ques", secQues);
                            rs.updateString("sec_ans", secAns);
                            rs.updateString("password", password);
                            rs.insertRow();
                            rs.close();
                            stmt.close();
                            con.close();
                            dos.writeBytes("signup_true\r\n");
                        } catch (Exception e) {
                            dos.writeBytes("signup_false\r\n");
                            e.printStackTrace();
                        }
                    } else if (request.equals("student_login")) {
                        String mob = dis.readLine();
                        String pass = dis.readLine();
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from student where phone='" + mob + "'and password='" + pass + "'");
                        if (rs.next()) {
                            dos.writeBytes("login_true\r\n");
                            studentName = rs.getString("name");
                            alStudent.add(this);
                            tableModel.fireTableDataChanged();
                        } else {
                            dos.writeBytes("login_false\r\n");
                        }

                    } else if (request.equals("message")) {
                        String message = dis.readLine();
                        discussion.jTextArea1TD.append(studentName + " : " + message + "\n");
                    } else if (request.equals("changepass")) {
                        String phn, passw, newp;

                        phn = dis.readLine();
                        passw = dis.readLine();
                        newp = dis.readLine();

                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from student where phone = '" + phn + "'and password = '" + passw + "'");

                        if (rs.next()) {
                            rs.updateString("password", newp);
                            rs.updateRow();
                            dos.writeBytes("changetrue\r\n");

                        } else {
                            dos.writeBytes("changefalse\r\n");
                        }

                        rs.close();
                        stmt.close();
                        con.close();

                    } else if (request.equals("forgetnext")) {
                        String pno = dis.readLine();
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from student where phone = '" + pno + "'");
                        if (rs.next()) {
                            String quess = rs.getString("sec_ques");
                            dos.writeBytes("forgetques\r\n");
                            dos.writeBytes(quess + "\r\n");
                        } else {
                            dos.writeBytes("forgetnodata\r\n");
                        }

                    } else if (request.equals("forgetpass")) {
                        String phn, passw, newp;

                        phn = dis.readLine();
                        passw = dis.readLine();
                        newp = dis.readLine();

                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from student where phone = '" + phn + "'and sec_ans = '" + passw + "'");

                        if (rs.next()) {
                            rs.updateString("password", newp);
                            rs.updateRow();
                            dos.writeBytes("forgettrue\r\n");

                        } else {
                            dos.writeBytes("forgetfalse\r\n");
                        }

                        rs.close();
                        stmt.close();
                        con.close();

                    }


                }
            } catch (Exception e) {
                alStudent.remove(this);
                tableModel.fireTableDataChanged();
            }
        }

    }

    class StudentTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return alStudent.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int i, int j) {
            if (j == 0) {
                return alStudent.get(i).studentName;
            } else {
                return alStudent.get(i).sock.getRemoteSocketAddress().toString();
            }
        }

        @Override
        public String getColumnName(int i) {
            if (i == 0) {
                return "Name";
            } else {
                return "IP Address";
            }
        }
    }
}