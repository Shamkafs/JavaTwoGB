package HomeWork1Java3;

import java.sql.*;

public class DataBaseAuthService implements AuthService {

    private static Connection connection;
    private static Statement statement;

    @Override
    public void start(){
        try {
            connect();
            createTable();
            insertUsersBatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:usersdbforchat.db");
        statement = connection.createStatement();
    }

    @Override
    public void stop() throws SQLException {
        dropTable();
        disconnect();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getNickByLoginAndPass(String login, String pass) {
        try (ResultSet rs = statement.executeQuery("select * from users")) {
            while (rs.next()) {
                if (rs.getString("login").equals(login) && rs.getString("pass").equals(pass)) {
                    return rs.getString("nick");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private  static void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists users (\n" +
                " id integer primary key autoincrement not null,\n" +
                " login text not null,\n" +
                " pass text not null,\n" +
                " nick text\n" +
                ");");
    }

    private static void insertUsersBatch() {
        try (PreparedStatement ps = connection.prepareStatement(
                "insert into users (login, pass, nick) " +
                        "values (?, ?, ?)")) {
            for (int i = 1; i < 5 ; i++) {
                ps.setString(1,"login" + i);
                ps.setString(2, "pass" + i);
                ps.setString(3, "nick" + i);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void dropTable() throws SQLException {
        statement.executeUpdate("drop table users");
    }

    public static void renameUsers(String nick, String login) throws SQLException {
        String newNick = "UPDATE users SET nick = " + nick + " WHERE login = " + login + "; ";
        PreparedStatement ps = connection.prepareStatement("UPDATE users SET nick = ? " + " WHERE login = ?;");
        ps.setString(1, newNick);
        ps.setString(2, login);
        ps.execute();
    }

}
