import javax.swing.*;
import java.io.*;
import java.net.Socket;

class FileSendingClient implements Runnable {

    DataInputStream disFile;
    DataOutputStream dosFile;
    File selectedFile;
    Socket socket;
    Server mServer;

    public FileSendingClient(String ipAddress, File selectedFile, Server server) {
        try {
            this.selectedFile = selectedFile;
            System.out.println(ipAddress);
            socket = new Socket(ipAddress, 10000);
            disFile = new DataInputStream(socket.getInputStream());
            dosFile = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            dosFile.writeBytes("getfile\r\n");
            dosFile.writeBytes(selectedFile.getName() + "\r\n");
            dosFile.writeLong(selectedFile.length());
            FileInputStream fis = new FileInputStream(selectedFile);
            byte[] buffer = new byte[1024 * 1024];
            while (true) {
                int r = fis.read(buffer, 0, buffer.length);
                if (r == -1) {
                    break;
                }
                dosFile.write(buffer, 0, r);
            }
            mServer.fileSentValue++;
            mServer.progressBar.jProgressBarFPB.setValue(mServer.fileSentValue);
            dosFile.close();
            if (mServer.fileSentValue == mServer.alStudent.size()) {
                JOptionPane.showMessageDialog(mServer, "File sent successfully to all students");
                mServer.progressBar.dispose();
                mServer.btSendFile.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                mServer.fileSentValue++;
                dosFile.close();
                if (mServer.fileSentValue >= mServer.alStudent.size()) {
                    mServer.progressBar.dispose();
                    mServer.btSendFile.setEnabled(true);
                    JOptionPane.showMessageDialog(mServer, "File sending successfully.");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}