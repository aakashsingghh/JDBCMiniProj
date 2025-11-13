package com.jdbc;

import com.jdbc.IMenu;
import com.jdbc.Menu;

    public class Main {
        public static void main(String[] args) {
            System.out.println("Welcome to JDBC!");
            IMenu menu = new Menu();
            menu.displayMenu();
        }
    }


