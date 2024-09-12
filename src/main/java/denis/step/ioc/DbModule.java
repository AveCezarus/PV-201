package denis.step.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;


import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbModule extends AbstractModule {
    private Connection connection = null;

    @Provides
    private Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = loadDbProperties("db.ini");
                String url = String.format("jdbc:%s://%s:%s/%s?useUnicode=true&characterEncoding=%s",
                        properties.getProperty("dbms"),
                        properties.getProperty("host"),
                        properties.getProperty("port"),
                        properties.getProperty("schema"),
                        properties.getProperty("characterEncoding"));

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = DriverManager.getConnection(
                        url,
                        properties.getProperty("user"),
                        properties.getProperty("password")
                );
            } catch (SQLException ex) {
                System.err.println("Ошибка при получении соединения: " + ex.getMessage());
            }
        }
        return connection;
    }

    private Properties loadDbProperties(String filePath) {
        Properties properties = new Properties();
        try (InputStream input = this.getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IOException("Файл не найден: " + filePath);
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла db.ini: " + e.getMessage());
        }
        return properties;
    }
}
