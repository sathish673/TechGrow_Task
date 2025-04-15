package management;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}

class Teacher {
    String name;
    String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
}

public class SchoolManagementSystem {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== School Management System =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageTeachers();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private static void manageStudents() {
        int choice;
        do {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n===== Student List =====");
            for (Student student : students) {
                System.out.println("Roll No: " + student.rollNumber + ", Name: " + student.name + ", Grade: " + student.grade);
            }
        }
    }

    private static void manageTeachers() {
        int choice;
        do {
            System.out.println("\n===== Teacher Management =====");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    viewTeachers();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

    private static void addTeacher() {
        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        teachers.add(new Teacher(name, subject));
        System.out.println("Teacher added successfully!");
    }

    private static void viewTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
        } else {
            System.out.println("\n===== Teacher List =====");
            for (Teacher teacher : teachers) {
                System.out.println("Name: " + teacher.name + ", Subject: " + teacher.subject);
            }
        }
    }
}

