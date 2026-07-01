package com.bugsense;

import java.util.Scanner;

import com.bugsense.menu.DashboardMenu;
import com.bugsense.model.User;
import com.bugsense.model.enums.Role;
import com.bugsense.service.BugService;
import com.bugsense.service.UserService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DashboardMenu dashboardMenu = new DashboardMenu(scanner);

        UserService userService = new UserService();
        BugService bugService = new BugService();

        while (true) {

            System.out.println("\n========== BugSense AI ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ==========================
                // REGISTER
                // ==========================
                case 1 -> {

                    User user = new User();

                    System.out.print("Full Name: ");
                    user.setFullName(scanner.nextLine());

                    System.out.print("Email: ");
                    user.setEmail(scanner.nextLine());

                    System.out.print("Password: ");
                    user.setPassword(scanner.nextLine());

                    user.setRole(Role.USER);

                    boolean success = userService.register(user);

                    if (success)
                        System.out.println("\n✅ Registration Successful!");
                    else
                        System.out.println("\n❌ Registration Failed.");
                }

                // ==========================
                // LOGIN
                // ==========================
                case 2 -> {

                    System.out.print("Email: ");
                    String email = scanner.next();

                    System.out.print("Password: ");
                    String password = scanner.next();

                    User loggedInUser = userService.login(email, password);

                    if (loggedInUser != null) {

                        System.out.println();
                        System.out.println("==================================");
                        System.out.println("Welcome " + loggedInUser.getFullName() + "!");
                        System.out.println("==================================");

                        // ==========================
                        // USER DASHBOARD
                        // ==========================

                        dashboardMenu.show(loggedInUser);


                    } else {

                        System.out.println();
                        System.out.println("❌ Invalid Email or Password!");

                    }
                }

                // ==========================
                // EXIT
                // ==========================
                case 3 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid Option");
            }
        }
    }
}