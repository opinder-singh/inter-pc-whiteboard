import javax.swing.*;
import java.util.ArrayList;

public class TeacherDiscussion extends JFrame {

    StudentListModel listModel;
    ArrayList<Server.ClientHandler> alStudent;
    String teachername = "";

    public TeacherDiscussion(ArrayList<Server.ClientHandler> alS, String teachernameARG) {
        alStudent = alS;
        teachername = teachernameARG;
        initComponents();
        //setLocationRelativeTo(Server.this);
        listModel = new StudentListModel(alStudent);
        listClientTD.setModel(listModel);
        setVisible(true);
        setSize(600, 520);
        jTextArea1TD.setFocusable(false);
        tfMessageTD.requestFocus();
    }

    private void initComponents() {

        jScrollPane1TD = new JScrollPane();
        jTextArea1TD = new JTextArea();
        tfMessageTD = new JTextField();
        listClientTD = new JList();
        btSendTD = new JButton();
        btBroadCastTD = new JButton();
        jlabelConnectedStud = new JLabel();

        getContentPane().setLayout(null);

        jTextArea1TD.setColumns(20);
        jTextArea1TD.setRows(5);
        jScrollPane1TD.setViewportView(jTextArea1TD);

        getContentPane().add(jScrollPane1TD);
        jScrollPane1TD.setBounds(10, 20, 340, 330);
        getContentPane().add(tfMessageTD);
        tfMessageTD.setBounds(10, 390, 340, 40);
        getContentPane().add(listClientTD);
        listClientTD.setBounds(390, 20, 160, 330);

        btSendTD.setText("SEND");
        btSendTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsendActionPerformed(evt);
            }
        });
        getContentPane().add(btSendTD);
        btSendTD.setBounds(379, 390, 80, 40);

        btBroadCastTD.setText("BROADCAST");
        btBroadCastTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbroadActionPerformed(evt);
            }
        });
        getContentPane().add(btBroadCastTD);
        btBroadCastTD.setBounds(470, 390, 110, 40);
        jlabelConnectedStud.setText("Connected Students");
        getContentPane().add(jlabelConnectedStud);
        jlabelConnectedStud.setBounds(420, 0, 130, 20);
        pack();
    }// </editor-fold>

    private void btsendActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String messagediscussion = tfMessageTD.getText().trim();
            if (messagediscussion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Type Message ");
                return;
            }
            int indexofselected = -1;
            indexofselected = listClientTD.getSelectedIndex();
            if (indexofselected == -1) {
                JOptionPane.showMessageDialog(this, "Please Select Student");
                return;
            }
            alStudent.get(indexofselected).dos.writeBytes("message\r\n");
            alStudent.get(indexofselected).dos.writeBytes(teachername + "\r\n");
            alStudent.get(indexofselected).dos.writeBytes(messagediscussion + "\r\n");
            jTextArea1TD.append("You to " + alStudent.get(indexofselected).studentName + " :" + messagediscussion + "\r\n");
            tfMessageTD.requestFocus();
            tfMessageTD.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void btbroadActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String messagediscussion = tfMessageTD.getText().trim();
            if (messagediscussion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Type Message ");
                return;
            }
            for (int i = 0; i < alStudent.size(); i++) {
                alStudent.get(i).dos.writeBytes("message\r\n");
                alStudent.get(i).dos.writeBytes(teachername + "\r\n");
                alStudent.get(i).dos.writeBytes(messagediscussion + "\r\n");
            }
            jTextArea1TD.append("You to ALL    :" + messagediscussion + "\r\n");
            tfMessageTD.requestFocus();
            tfMessageTD.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JButton btBroadCastTD;
    private JButton btSendTD;
    private JScrollPane jScrollPane1TD;
    JTextArea jTextArea1TD;
    private JList listClientTD;
    private JTextField tfMessageTD;
    private JLabel jlabelConnectedStud;
    // End of variables declaration
}