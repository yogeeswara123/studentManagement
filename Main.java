package studentManagement;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        StudentDAO dao = new StudentDAO();
        statisticsService stats = new statisticsService();

        System.out.println("==== Admin Login ====");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!auth.adminLogin(user, pass)) {
            System.out.println("Invalid credentials.");
            return;
        }
        while (true) {
            System.out.println("\n==== Student Management Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
            case 1:
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Course: "); String course = sc.nextLine();
                System.out.print("Age: "); int age = sc.nextInt();
                System.out.print("Grade: "); float grade = sc.nextFloat();
                sc.nextLine();
                dao.addStudent(new Student(0, name, email, course, age, grade));
                break;
            case 2:
                for (Student s : dao.getAllStudents()) {
                    System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
                }
                break;
            case 3:
                System.out.print("Enter ID to update: "); int uid = sc.nextInt(); sc.nextLine();
                System.out.print("New Name: "); name = sc.nextLine();
                System.out.print("New Email: "); email = sc.nextLine();
                System.out.print("New Course: "); course = sc.nextLine();
                System.out.print("New Age: "); age = sc.nextInt();
                System.out.print("New Grade: "); grade = sc.nextFloat();
                dao.updateStudent(uid, new Student(uid, name, email, course, age, grade));
                break;
            case 4:
                System.out.print("Enter ID to delete: "); int did = sc.nextInt();
                dao.deleteStudent(did);
                break;

            case 5:
                System.out.print("Enter keyword to search: "); String key = sc.nextLine();
                for (Student s : dao.searchStudents(key)) {
                    System.out.println(s.getId() + " | " + s.getName() + " | " + s.getCourse());
                }
                break;

            case 6:
                stats.showStatistics();
                break;
            case 7:
                System.out.println("Exiting system.");
                return;

            default:
                System.out.println("Invalid option.");
        }
    }
}
}