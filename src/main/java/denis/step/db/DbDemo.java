package denis.step.db;

import com.google.inject.Inject;
import java.sql.*;
import java.util.Map;

public class DbDemo {
    @Inject
    private Connection connection;

    public void run(boolean showJournal) {
        if (showJournal) {
            showJournal();
        } else {
            logStart();
            System.out.println("App started and logged.");
        }
    }

    private void logStart() {
        try {
            String query = "INSERT INTO app_log (start_time) VALUES (CURRENT_TIMESTAMP)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error logging start time: " + e.getMessage());
        }
    }

    private void showJournal() {
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM app_log");
            while (res.next()) {
                int id = res.getInt("id");
                Timestamp startTime = res.getTimestamp("start_time");
                System.out.println("ID: " + id + ", Start Time: " + startTime);
            }
            res.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error retrieving journal: " + e.getMessage());
        }
    }
}
