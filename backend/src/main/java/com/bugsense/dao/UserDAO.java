package com.bugsense.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bugsense.model.User;
import com.bugsense.model.enums.Role;
import com.bugsense.util.DatabaseConnection;



public class UserDAO {

    public boolean registerUser(User user) {

        String sql = """
                INSERT INTO users(full_name, email, password, role)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole().name());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findByEmail(String email) {

    String sql = "SELECT * FROM users WHERE email = ?";

    try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
    ) {

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            User user = new User();

            user.setId(rs.getInt("id"));
            user.setFullName(rs.getString("full_name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(Role.valueOf(rs.getString("role")));

            return user;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}