package HomeWork6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try (ServerSocket serverSocket = new ServerSocket(8089)) {
            System.out.println("Сервер ожидает подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился!");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner inMessage = new Scanner(System.in);

            Thread messageFromServer = new Thread(() -> {

                while (true) {
                    System.out.println("Введите сообщение: ");
                    String message = scanner.nextLine();
                    try {
                        dataOutputStream.writeUTF("Admin: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
            messageFromServer.setDaemon(true);
            messageFromServer.start();

            while (true) {
                String message = dataInputStream.readUTF();
                if (message.equals("/end")) {
                    dataOutputStream.writeUTF(message);
                    break;
                }
                System.out.println("Клиент прислал:" + message);
                dataOutputStream.writeUTF("Client: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
