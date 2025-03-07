package voting;

import java.sql.*;
import java.util.Scanner;

public class OnlineVotingSystem {
    private static final String url = "jdbc:mysql://localhost:3306/votingtask";
    private static final String user = "root"; 
    private static final String password = "12345"; 
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            System.out.println("Welcome to the Online Voting System");
            while (true) {
                System.out.println("1. Register\n2. Login\n3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        registerUser(connection, scanner);
                        break;
                    case 2:
                        loginUser(connection, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registerUser(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("enter cast");
        String cast = scanner.nextLine();

        String sql = "INSERT INTO users (username, password,cast) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, cast);
            stmt.executeUpdate();
            System.out.println("Registration successful!");
        }
    }

    private static void loginUser(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + username);
                votingMenu(conn, scanner);
            } else {
                System.out.println("Invalid credentials.");
            }
        }
    }

    private static void votingMenu(Connection conn, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("1. Vote\n2. View Results\n3. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    castVote(conn, scanner);
                    break;
                case 2:
                    viewResults(conn);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void castVote(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Available candidates:");
        String sql = "SELECT * FROM candidates";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name"));
            }
        }
        System.out.print("Enter candidate ID to vote: ");
        int candidateId = scanner.nextInt();
        sql = "UPDATE candidates SET votes = votes + 1 WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, candidateId);
            stmt.executeUpdate();
            System.out.println("Vote cast successfully!");
        }
    }

    private static void viewResults(Connection conn) throws SQLException {
        System.out.println("Election Results:");
        String sql = "SELECT * FROM candidates ORDER BY votes DESC";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getInt("votes") + " votes");
            }
        }
    }
}
