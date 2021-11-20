package HomeWork7.server;

import HomeWork7.constants.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;


public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    private Timer timer;

    public ClientHandler(MyServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    ClientHandler.this.authentification();
                    ClientHandler.this.readMessage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    ClientHandler.this.closeConnection();
                }
            }).start();

        } catch (IOException ex) {
            throw new RuntimeException("Проблемы при создании обработчика");
        }
    }

    private void authentification() throws IOException {

        TimerTask task = new TimerTask() {
            public void run() {
                sendMessage("Слишком долго проходила авторизация. Соединение разорвано");
                closeConnection();
            }
        };
        timer = new Timer();
        timer.schedule(task, Constants.TIME);

        while (true) {
            String str = in.readUTF();
            if (str.startsWith(Constants.AUTH_COMMAND)) {
                String[] tokens = str.split("\\s+");
                Optional<String> nick = server.getAuthService().getNickByLoginAndPass(tokens[1], tokens[2]);

                if (nick.isPresent()) {
                    if (server.isNickBusy(nick.get())) {
                        sendMessage("Учетная запись уже используется");
                    } else {
                        name = nick.get();
                        sendMessage(Constants.AUTH_OK_COMMAND + " как: " + name);
                        server.broadcastMessage(name + " вошёл в чат");
                        server.subscribe(this);
                        timer.cancel();
                        return;
                    }
                } else {
                    sendMessage("Неверные логин/пароль");
                }

            }

        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readMessage() throws IOException {
            while (true) {
                String messageFromClient = in.readUTF();

                if (messageFromClient.startsWith(Constants.CLIENTS_LIST_COMMAND)) {
                    sendMessage(server.getActiveClients());
                } else {

                    String[] tokens = messageFromClient.split("\\s+");

                    if (tokens[0].equals(Constants.PRIVATE_MESSAGE)) {
                        int length = tokens.length - 2;
                        String[] message = new String[length];
                        System.arraycopy(tokens, 2, message, 0, message.length);
                        server.privateSendMessage("Личное сообщение от " + name + ": " + String.join(" ", message), tokens[1], name);
                        System.out.println("Сообщение от " + name + ": " + messageFromClient);
                    } else {
                        System.out.println("Сообщение от " + name + ": " + messageFromClient);
                        server.broadcastMessage(name + ": " + messageFromClient);
                    }
                    if (messageFromClient.equals(Constants.END_COMMAND)) {
                        break;
                    }
                }
            }
    }


    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(getName() + " вышел из чата");
        try {
            in.close();
        } catch (IOException ex) {
            //ignore
        }
        try {
            out.close();
        } catch (IOException ex) {
            //ignore
        }
        try {
            socket.close();
        } catch (IOException ex) {
            //ignore
        }
    }

    public String getName() {
        return name;
    }
}
