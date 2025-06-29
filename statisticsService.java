package studentManagement;
import java.sql.*;

public class statisticsService {
    public void showStatistics() {
        String sql = "SELECT COUNT(*) AS total, AVG(age) AS avg_age, AVG(grade) AS avg_grade FROM students";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("Total Students: " + rs.getInt("total"));
                System.out.println("Average Age: " + rs.getDouble("avg_age"));
                System.out.println("Average Grade: " + rs.getDouble("avg_grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}