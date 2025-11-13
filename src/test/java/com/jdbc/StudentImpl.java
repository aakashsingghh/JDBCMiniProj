package com.jdbc;

import com.jdbc.ConnectionImpl;
import com.jdbc.IStudent;

import java.sql.*;
import java.util.Scanner;

public class StudentImpl implements IStudent {
    IConnection conn = new ConnectionImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void insertStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        String query = "INSERT INTO students(name, age, email) VALUES(?, ?, ?)";
        try (Connection c = conn.createConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.executeUpdate();
            System.out.println("Student inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMultipleStudents() {
        System.out.print("How many students to insert? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            insertStudent();
        }
    }

    @Override
    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new email: ");
        String email = sc.nextLine();

        String query = "UPDATE students SET email=? WHERE id=?";
        try (Connection c = conn.createConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println(" Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMultipleStudents() {
        System.out.print("How many students to update? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            updateStudent();
        }
    }

    @Override
    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        String query = "DELETE FROM students WHERE id=?";
        try (Connection c = conn.createConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMultipleStudents() {
        System.out.print("How many students to delete? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            deleteStudent();
        }
    }

    @Override
    public void showStudents() {
        String query = "SELECT * FROM students";
        try (Connection c = conn.createConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nID\tName\tAge\tEmail");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getInt("age") + "\t"
                        + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}