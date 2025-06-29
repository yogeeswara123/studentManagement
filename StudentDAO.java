package studentManagement;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, course, age, grade) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, Student.getName());
            stmt.setString(2, Student.getEmail());
            stmt.setString(3, Student.getCourse());
            stmt.setInt(4, Student.getAge());
            stmt.setFloat(5, Student.getGrade());
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getInt("age"),
                    rs.getFloat("grade")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void updateStudent(int id, Student updatedStudent) {
        String sql = "UPDATE students SET name=?, email=?, course=?, age=?, grade=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, updatedStudent.getName());
            stmt.setString(2, updatedStudent.getEmail());
            stmt.setString(3, updatedStudent.getCourse());
            stmt.setInt(4, updatedStudent.getAge());
            stmt.setFloat(5, updatedStudent.getGrade());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Student deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Student> searchStudents(String keyword) {
        List<Student> results = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name LIKE ? OR course LIKE ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                results.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getInt("age"),
                    rs.getFloat("grade")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}