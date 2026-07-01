package com.bugsense.service;

import java.util.List;

import com.bugsense.dao.BugDAO;
import com.bugsense.model.Bug;
import com.bugsense.model.enums.Status;

public class BugService {

    private final BugDAO bugDAO;

    public BugService() {
        bugDAO = new BugDAO();
    }

    // ==========================
    // Create Bug
    // ==========================
    public boolean createBug(Bug bug) {

        if (bug == null) {
            System.out.println("Bug cannot be null.");
            return false;
        }

        if (bug.getTitle() == null || bug.getTitle().trim().isEmpty()) {
            System.out.println("Bug title cannot be empty.");
            return false;
        }

        if (bug.getDescription() == null || bug.getDescription().trim().isEmpty()) {
            System.out.println("Bug description cannot be empty.");
            return false;
        }

        return bugDAO.createBug(bug);
    }

    // ==========================
    // Get All Bugs
    // ==========================
    public List<Bug> getAllBugs() {
        return bugDAO.getAllBugs();
    }

    // ==========================
    // Get Bugs By User
    // ==========================
    public List<Bug> getBugsByUser(int reporterId) {
        return bugDAO.getBugsByUser(reporterId);
    }

    // ==========================
    // Get Bug By ID
    // ==========================
    public Bug getBugById(int id) {
        return bugDAO.getBugById(id);
    }

    // ==========================
    // Update Bug Status
    // ==========================
    public boolean updateBugStatus(int id, String status) {

        if (status == null) {
            return false;
        }

        try {

            Status bugStatus = Status.valueOf(status.toUpperCase());

            return bugDAO.updateBugStatus(id, bugStatus);

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid Status!");
            System.out.println("Allowed values:");
            System.out.println("OPEN");
            System.out.println("IN_PROGRESS");
            System.out.println("RESOLVED");
            System.out.println("CLOSED");

            return false;
        }
    }

    // ==========================
    // Delete Bug
    // ==========================
    public boolean deleteBug(int id) {
        return bugDAO.deleteBug(id);
    }

}