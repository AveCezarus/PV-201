package denis.step.db;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class IniFileWriter {
    public void writeDbIniFile(String filePath) {
        Properties properties = new Properties();
        properties.setProperty("dbms", "mysql");
        properties.setProperty("host", "localhost");
        properties.setProperty("port", "3308");
        properties.setProperty("schema", "java_pv222");
        properties.setProperty("user", "user222");
        properties.setProperty("password", "pass222");
        properties.setProperty("characterEncoding", "utf8");

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            properties.store(writer, "Database Configuration");
        } catch (IOException e) {
            System.err.println("Error writing db.ini file: " + e.getMessage());
        }
    }
}
