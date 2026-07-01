package com.bugsense.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bugsense.model.Bug;
import com.bugsense.model.enums.Priority;
import com.bugsense.model.enums.Status;
import com.bugsense.util.DatabaseConnection;

public class BugDAO {

    // ===========================
    // CREATE BUG
    // ===========================

    public boolean createBug(Bug bug) {

        String sql = """
                INSERT INTO bugs
                (title, description, priority, status, reporter_id)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getPriority().name());
            ps.setString(4, bug.getStatus().name());
            ps.setInt(5, bug.getReporterId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    // ===========================
// GET ALL BUGS
// ===========================

public List<Bug> getAllBugs() {

    List<Bug> bugs = new ArrayList<>();

    String sql = "SELECT * FROM bugs ORDER BY created_at DESC";

    try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {

            Bug bug = new Bug();

            bug.setId(rs.getInt("id"));
            bug.setTitle(rs.getString("title"));
            bug.setDescription(rs.getString("description"));

            bug.setPriority(
                    Priority.valueOf(rs.getString("priority"))
            );

            bug.setStatus(
                    Status.valueOf(rs.getString("status"))
            );

            bug.setReporterId(rs.getInt("reporter_id"));

            bug.setAiSummary(rs.getString("ai_summary"));
            bug.setAiRootCause(rs.getString("ai_root_cause"));
            bug.setAiReproductionSteps(rs.getString("ai_reproduction_steps"));

            bug.setCreatedAt(rs.getTimestamp("created_at"));
            bug.setUpdatedAt(rs.getTimestamp("updated_at"));

            bugs.add(bug);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return bugs;
}

    
    // ===========================
    // GET ALL BUGS OF A USER
    // ===========================

    public List<Bug> getBugsByUser(int reporterId) {

        List<Bug> bugs = new ArrayList<>();

        String sql = """
                SELECT * FROM bugs
                WHERE reporter_id = ?
                ORDER BY created_at DESC
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, reporterId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Bug bug = new Bug();

                bug.setId(rs.getInt("id"));
                bug.setTitle(rs.getString("title"));
                bug.setDescription(rs.getString("description"));

                bug.setPriority(
                        Priority.valueOf(rs.getString("priority"))
                );

                bug.setStatus(
                        Status.valueOf(rs.getString("status"))
                );

                bug.setReporterId(rs.getInt("reporter_id"));

                bug.setAiSummary(rs.getString("ai_summary"));
                bug.setAiRootCause(rs.getString("ai_root_cause"));
                bug.setAiReproductionSteps(rs.getString("ai_reproduction_steps"));

                bugs.add(bug);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bugs;
    }

    // ===========================
    // FIND BUG BY ID
    // ===========================

    public Bug getBugById(int bugId) {

        String sql = "SELECT * FROM bugs WHERE id = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, bugId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Bug bug = new Bug();

                bug.setId(rs.getInt("id"));
                bug.setTitle(rs.getString("title"));
                bug.setDescription(rs.getString("description"));

                bug.setPriority(
                        Priority.valueOf(rs.getString("priority"))
                );

                bug.setStatus(
                        Status.valueOf(rs.getString("status"))
                );

                bug.setReporterId(rs.getInt("reporter_id"));

                bug.setAiSummary(rs.getString("ai_summary"));
                bug.setAiRootCause(rs.getString("ai_root_cause"));
                bug.setAiReproductionSteps(rs.getString("ai_reproduction_steps"));

                return bug;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ===========================
    // UPDATE BUG STATUS
    // ===========================

    public boolean updateBugStatus(int bugId, Status status) {

        String sql = """
                UPDATE bugs
                SET status = ?
                WHERE id = ?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, status.name());
            ps.setInt(2, bugId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ===========================
    // DELETE BUG
    // ===========================

    public boolean deleteBug(int bugId) {

        String sql = "DELETE FROM bugs WHERE id = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, bugId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}