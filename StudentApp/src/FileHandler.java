import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

class FileHandler implements Runnable {
        //Socket socket;
        private DataInputStream disFile;
        private DataOutputStream dosFile;
        String fileRequest;

        public FileHandler(Socket socket) {
            try {
                //this.socket = socket;
                disFile = new DataInputStream(socket.getInputStream());
                dosFile = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            FileProgressBar fileProgressBar = null;
            try {
                fileRequest = disFile.readLine();
                if (fileRequest.equals("getfile")) {
                    String fileName = disFile.readLine();
                    int fileSize = (int) disFile.readLong();
                    fileProgressBar = new FileProgressBar(fileName, fileSize);
                    fileProgressBar.setLocation(500,100);
                    File output = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "White Board Downloads");
                    if (!output.exists()) {
                        output.mkdirs();
                    }
                    FileOutputStream fos = new FileOutputStream(output.getPath() + File.separator + fileName);
                    byte[] buffer = new byte[1024 * 1024];
                    int count = 0;
                    while (true) {
                        int read = disFile.read(buffer, 0, buffer.length);
                        fos.write(buffer, 0, read);
                        if ((count += read) == fileSize) {
                            break;
                        }
                        fileProgressBar.jProgBar.setValue(count);
                    }
                    JOptionPane.showMessageDialog(fileProgressBar, "File Received:\t" + "\" " + fileName + "\"\nFile Path:\t" + output.getPath());
                    fileProgressBar.dispose();
                    fos.close();
                }
            } catch (Exception e) {
                if (fileProgressBar != null) {
                    fileProgressBar.dispose();
                }
                JOptionPane.showMessageDialog(fileProgressBar, "File Receiving failed.");
            }
        }
    }
