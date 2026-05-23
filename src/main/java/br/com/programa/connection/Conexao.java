package br.com.programa.connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    private static final String USERNAME = dotenv.get("DB_USERNAME");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");
    private static final String HOST = dotenv.get("DB_HOST", "localhost");
    private static final String PORT = dotenv.get("DB_PORT", "3306");
    private static final String DATABASE = dotenv.get("DB_NAME");
    private static final String DATABASE_URL = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", HOST, PORT, DATABASE);

    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;

    }

    public static void main(String[] args) throws Exception {
        Connection c = createConnectionToMySQL();
        if (c != null) {
            System.out.println("Conexão obtida com sucesso!");
            c.close();
        }
    }
}
