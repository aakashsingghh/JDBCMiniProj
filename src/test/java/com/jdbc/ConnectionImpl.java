package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConnectionImpl implements IConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
        private static final String USER = "root";
        private static final String PASSWORD = "Ash334sin";

        @Override
        public Connection createConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

