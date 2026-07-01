package com.bugsense.menu;

import java.util.List;
import java.util.Scanner;

import com.bugsense.model.Bug;
import com.bugsense.model.User;
import com.bugsense.model.enums.Priority;
import com.bugsense.model.enums.Status;
import com.bugsense.service.BugService;

public class DashboardMenu {

    private final BugService bugService;
    private final Scanner scanner;

    public DashboardMenu(Scanner scanner) {
        this.scanner = scanner;
        this.bugService = new BugService();
    }

    public void show(User loggedInUser) {

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println("\n========== BugSense ==========");
            System.out.println("1. Create Bug");
            System.out.println("2. View My Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Delete Bug");
            System.out.println("5. Logout");
            System.out.print("Choose Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> createBug(loggedInUser);

                case 2 -> viewMyBugs(loggedInUser);

                case 3 -> updateBug();

                case 4 -> deleteBug();

                case 5 -> {
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                }

                default -> System.out.println("Invalid Option.");
            }
        }
    }

    // ==========================
    // CREATE BUG
    // ==========================

    private void createBug(User user) {

        System.out.println("\n========== Create Bug ==========");

        Bug bug = new Bug();

        System.out.print("Title: ");
        bug.setTitle(scanner.nextLine());

        System.out.print("Description: ");
        bug.setDescription(scanner.nextLine());

        System.out.print("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");

        try {

            bug.setPriority(
                    Priority.valueOf(scanner.nextLine().toUpperCase())
            );

            bug.setStatus(Status.OPEN);

            bug.setReporterId(user.getId());

            if (bugService.createBug(bug)) {

                System.out.println("\n✅ Bug Created Successfully!");

            } else {

                System.out.println("\n❌ Failed to Create Bug.");

            }

        } catch (Exception e) {

            System.out.println("Invalid Priority!");

        }

    }

    // ==========================
    // VIEW BUGS
    // ==========================

    private void viewMyBugs(User user) {

        List<Bug> bugs = bugService.getBugsByUser(user.getId());

        if (bugs.isEmpty()) {

            System.out.println("\nNo Bugs Found.");

            return;
        }

        System.out.println("\n========== MY BUGS ==========");

        for (Bug bug : bugs) {

            System.out.println("--------------------------------");
            System.out.println("ID : " + bug.getId());
            System.out.println("Title : " + bug.getTitle());
            System.out.println("Priority : " + bug.getPriority());
            System.out.println("Status : " + bug.getStatus());

        }

    }

    // ==========================
    // UPDATE
    // ==========================

    private void updateBug() {

        System.out.print("\nBug ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Status (OPEN/IN_PROGRESS/RESOLVED/CLOSED): ");

        String status = scanner.nextLine();

        if (bugService.updateBugStatus(id, status)) {

            System.out.println("\n✅ Bug Updated!");

        } else {

            System.out.println("\n❌ Update Failed.");

        }

    }

    // ==========================
    // DELETE
    // ==========================

    private void deleteBug() {

        System.out.print("\nBug ID : ");

        int id = scanner.nextInt();
        scanner.nextLine();

        if (bugService.deleteBug(id)) {

            System.out.println("\n✅ Bug Deleted!");

        } else {

            System.out.println("\n❌ Delete Failed.");

        }

    }

}