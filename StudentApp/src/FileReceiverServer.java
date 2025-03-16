import java.net.ServerSocket;
import java.net.Socket;

class FileReceiverServer implements Runnable {

        ServerSocket serverSocket;

        public void run() {
            try {
                serverSocket = new ServerSocket(10000);
                System.out.println("File Server Running");
                while (true) {
                    Socket socket = serverSocket.accept();
                    FileHandler fileHandler = new FileHandler(socket);
                    Thread thread = new Thread(fileHandler);
                    thread.start();
                }
            } catch (Exception e) {
            }
        }
    }
