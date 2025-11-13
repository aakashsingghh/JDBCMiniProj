package com.jdbc;

import com.jdbc.StudentImpl;
import java.util.Scanner;

    public class Menu implements IMenu {
        @Override
        public void displayMenu() {
            Scanner sc = new Scanner(System.in);
            StudentImpl s = new StudentImpl();

            while (true) {
                System.out.println("\n--- Student Database Menu ---");
                System.out.println("1. Insert a student");
                System.out.println("2. Insert multiple students");
                System.out.println("3. Update a student");
                System.out.println("4. Update multiple students");
                System.out.println("5. Delete a student");
                System.out.println("6. Delete multiple students");
                System.out.println("7. Show students");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> s.insertStudent();
                    case 2 -> s.insertMultipleStudents();
                    case 3 -> s.updateStudent();
                    case 4 -> s.updateMultipleStudents();
                    case 5 -> s.deleteStudent();
                    case 6 -> s.deleteMultipleStudents();
                    case 7 -> s.showStudents();
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }

