import java.io.DataOutputStream;
class StudentDiscussion extends javax.swing.JFrame {
private DataOutputStream mDOS=null;
        public StudentDiscussion(DataOutputStream dos) {
            //setLocationRelativeTo(Client.this);
            initComponents();
            textArea_message_history_SD.setFocusable(false);
            setVisible(true);
            setSize(500, 500);
            mDOS=dos;
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            btSendSD = new javax.swing.JButton();
            jScrollPane1SD = new javax.swing.JScrollPane();
            textArea_message_history_SD = new javax.swing.JTextArea();
            textField_messageSD = new javax.swing.JTextField();

            getContentPane().setLayout(null);

            btSendSD.setText("SEND");
            btSendSD.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnsendActionPerformed(evt);
                }
            });
            getContentPane().add(btSendSD);
            btSendSD.setBounds(340, 300, 80, 40);

            textArea_message_history_SD.setColumns(20);
            textArea_message_history_SD.setRows(5);
            jScrollPane1SD.setViewportView(textArea_message_history_SD);

            getContentPane().add(jScrollPane1SD);
            jScrollPane1SD.setBounds(10, 10, 420, 280);
            getContentPane().add(textField_messageSD);
            textField_messageSD.setBounds(10, 300, 320, 40);

            pack();
        }// </editor-fold>                        

        private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {
            try {
                String message = textField_messageSD.getText().trim();
                textArea_message_history_SD.append("You : " + message + "\n");
                mDOS.writeBytes("message\r\n");
                mDOS.writeBytes(message + "\r\n");
                textField_messageSD.requestFocus();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btSendSD;
        private javax.swing.JScrollPane jScrollPane1SD;
        javax.swing.JTextArea textArea_message_history_SD;
        private javax.swing.JTextField textField_messageSD;
        // End of variables declaration                   
    }