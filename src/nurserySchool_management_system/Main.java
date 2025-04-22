package nurserySchool_management_system;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, NurseryClass> classes = new HashMap<>();
    private static final Set<String> studentIds = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("=== Nursery School Management System ===");

        while (true) {
            System.out.println("\n1. Create Class");
            System.out.println("2. Assign Teacher");
            System.out.println("3. Enroll Student");
            System.out.println("4. Conduct Activity");
            System.out.println("5. Track Progress");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> createClass();
                case 2 -> assignTeacher();
                case 3 -> enrollStudent();
                case 4 -> conductActivity();
                case 5 -> trackProgress();
                case 6 -> generateReport();
                case 7 -> {
                    System.out.println("Exiting system.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void createClass() {
        System.out.print("Enter class ID: ");
        String classId = scanner.nextLine();
        System.out.println("Class Types: 1. Baby 2. Middle 3. Top");
        System.out.print("Enter type (1/2/3): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1 -> classes.put(classId, new BabyClass(classId));
            case 2 -> classes.put(classId, new MiddleClass(classId));
            case 3 -> classes.put(classId, new TopClass(classId));
            default -> System.out.println("Invalid class type.");
        }
    }

    private static void assignTeacher() {
        System.out.print("Enter class ID to assign teacher: ");
        String classId = scanner.nextLine();
        NurseryClass cls = classes.get(classId);
        if (cls == null) {
            System.out.println("Class not found.");
            return;
        }

        System.out.print("Enter teacher ID: ");
        String teacherId = scanner.nextLine();

        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name. Only letters allowed.");
            return;
        }

        System.out.print("Enter teacher role: ");
        String role = scanner.nextLine();

        if (cls instanceof BabyClass && !role.equalsIgnoreCase("Early Childhood Educator")) {
            System.out.println("Baby Class requires 'Early Childhood Educator'.");
            return;
        }

        cls.assignTeacher(new Teacher(teacherId, name, role));
        System.out.println("Teacher assigned.");
    }

    private static void enrollStudent() {
        System.out.print("Enter class ID to enroll student: ");
        String classId = scanner.nextLine();
        NurseryClass cls = classes.get(classId);
        if (cls == null) {
            System.out.println("Class not found.");
            return;
        }

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        if (studentIds.contains(studentId)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name. Only letters allowed.");
            return;
        }

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter guardian name: ");
        String guardian = scanner.nextLine();
        if (!guardian.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid guardian name. Only letters allowed.");
            return;
        }

        Student student = new Student(studentId, name, age, guardian);
        boolean success = cls.enrollStudent(student);
        if (success) {
            studentIds.add(studentId);
            System.out.println("Student enrolled.");
        } else {
            System.out.println("Enrollment failed. Age or capacity issue.");
        }
    }

    private static void conductActivity() {
        System.out.print("Enter class ID: ");
        String classId = scanner.nextLine();
        NurseryClass cls = classes.get(classId);
        if (cls == null) {
            System.out.println("Class not found.");
            return;
        }

        System.out.print("Enter activity name: ");
        String activity = scanner.nextLine();
        cls.conductActivity(activity);
        System.out.println("Activity recorded.");
    }

    private static void trackProgress() {
        System.out.print("Enter class ID: ");
        String classId = scanner.nextLine();
        NurseryClass cls = classes.get(classId);
        if (cls == null) {
            System.out.println("Class not found.");
            return;
        }

        cls.trackProgress();
        System.out.println("Progress updated.");
    }

    private static void generateReport() {
        System.out.print("Enter class ID: ");
        String classId = scanner.nextLine();
        NurseryClass cls = classes.get(classId);
        if (cls == null) {
            System.out.println("Class not found.");
            return;
        }

        cls.generateClassReport();
    }
}

