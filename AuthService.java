package studentManagement;
import java.sql.*;

public class AuthService {
    public boolean adminLogin(String username, String password) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?")) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Login success if a record is found

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}