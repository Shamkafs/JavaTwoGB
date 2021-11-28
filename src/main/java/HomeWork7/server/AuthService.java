package HomeWork7.server;

import java.sql.SQLException;

public interface AuthService {

    void start() throws SQLException;

    void stop() throws SQLException;

    String getNickByLoginAndPass(String login, String pass);


}
