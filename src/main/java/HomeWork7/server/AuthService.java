package HomeWork7.server;

public interface AuthService {

    void start();

    void stop();

    String getNickByLoginAndPass(String login, String pass);

}
