package app.vercel.waqar963.repository;

import app.vercel.waqar963.dto.UserDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {

    private final DataSource dataSource;
    private static final Logger logger = Logger.getLogger(UserRepository.class.getName());

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addUser(String name) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO contactsdb.USERS (name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();
            logger.info("User added: " + name);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding user: " + name, e);
        }
    }

    public void deleteUser(String name) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM contactsdb.USERS WHERE name = ?");
            ps.setString(1, name);
            int affected = ps.executeUpdate();
            if (affected > 0) {
                logger.info("User deleted: " + name);
            } else {
                logger.warning("No user found to delete: " + name);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting user: " + name, e);
        }
    }

    public void updateUser(int id, String newName) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE contactsdb.USERS SET name = ? WHERE id = ?");
            ps.setString(1, newName);
            ps.setInt(2, id);
            int updated = ps.executeUpdate();
            if (updated > 0) {
                logger.info("User updated: ID=" + id + ", new name=" + newName);
            } else {
                logger.warning("No user found with ID=" + id + " to update.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating user ID: " + id, e);
        }
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM contactsdb.USERS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new UserDTO(rs.getInt("id"), rs.getString("name")));
            }
            logger.info("Fetched " + users.size() + " users from DB.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching users", e);
        }
        return users;
    }

    public boolean userExists(String name) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM contactsdb.USERS WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error checking if user exists: " + name, e);
        }
        return false;
    }

    public boolean existsById(int id) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM contactsdb.USERS WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error checking if user ID exists: " + id, e);
        }
        return false;
    }
}
