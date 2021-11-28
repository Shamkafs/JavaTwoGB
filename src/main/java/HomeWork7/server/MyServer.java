package HomeWork7.server;

import HomeWork7.constants.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MyServer {

    private AuthService authService;
    private List<ClientHandler> clients;

    public AuthService getAuthService() {
        return authService;
    }

    public List<ClientHandler> getClients() {
        return clients;
    }

    public MyServer() throws SQLException {
        try (ServerSocket server = new ServerSocket(Constants.SERVER_PORT)) {
            authService = new DataBaseAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }

        } catch (IOException ex) {
            System.out.println("Ошибка в работе сервера");
            ex.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMessage(message));
        /*for (ClientHandler client : clients) {
            client.sendMessage(message);
        }*/
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public synchronized void privateSendMessage(String message, String privateName, String sender) {

        for (ClientHandler client : clients) {
            if (client.getName().equals(privateName)) {
                for (ClientHandler client2 : clients) {
                    if (client2.getName().equals(sender)) {
                        client.sendMessage(message);
                        String[] senderTokens = message.split("\\s+");
                        int length = senderTokens.length - 2;
                        String[] str = new String[length];
                        System.arraycopy(senderTokens, 2, str, 0, str.length);
                        client2.sendMessage("Личное сообщение для " + privateName + " " + String.join(" ", str));
                        return;
                    }
                }
            }
        }
        for (ClientHandler client : clients) {
            if (client.getName().equals(sender)) {
                client.sendMessage("Пользователь не в сети или такого пользователя не существует");
                return;
            }
        }
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler client : getClients()) {
            if (nick.equals(client.getName()))
                return true;
        }
        return false;
    }

    public synchronized String getActiveClients() {
        StringBuilder sb = new StringBuilder(Constants.CLIENTS_LIST_COMMAND).append(" ");
        sb.append(clients.stream()
                .map(ClientHandler::getName)
                .collect(Collectors.joining(" ")));
        /*for (ClientHandler clientHandler : clients) {
            sb.append(clientHandler.getName()).append(" ");
        }*/
        return sb.toString();
    }
}
