package attendancemangement;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String date;
    String status;

    public Student(String name, String date, String status) {
        this.name = name;
        this.date = date;
        this.status = status;
    }
}

public class AttendanceManagementSystem
{
    private static final ArrayList<Student> attendanceList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== Attendance Management System =====");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    markAttendance();
                    break;
                case 2:
                    viewAttendanceRecords();
                    break;
                case 3:
                	System.out.println("Exit.....Thank you");
                	break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private static void markAttendance() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Status (Present/Absent): ");
        String status = scanner.nextLine();

        attendanceList.add(new Student(name, date, status));
        System.out.println("Attendance marked successfully!");
    }

    private static void viewAttendanceRecords() 
    {
        if (attendanceList.isEmpty())
        {
            System.out.println("No attendance records found.");
        } else
        {
            System.out.println("\n===== Attendance Records =====");
            for (int i = 0; i < attendanceList.size(); i++) 
            {
                Student student = attendanceList.get(i);
                System.out.println((i + 1) + ". " + student.name + " | " + student.date + " | " + student.status);
            }
        }
    }
}

