package app.vercel.waqar963;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) {
    DataSource dataSource = DatabaseConfig.getDataSource();
    createDatabaseIfNotExists(dataSource);
    createTableIfNotExists(dataSource);
    addUser(dataSource, "Hijab-e-Zahra");
    getAllUsers(dataSource);
}

private static void addUser(DataSource dataSource, String name) {
    if (userExists(dataSource, name)) {
        System.out.println("User " + name + " already exists.");
        return;
    }
    
    try (Connection conn = dataSource.getConnection()) {
        PreparedStatement addUserStmt = conn.prepareStatement(
            "INSERT INTO contactsdb.USERS (name) VALUES (?)"
        );
        addUserStmt.setString(1, name);
        addUserStmt.executeUpdate();
        System.out.println("User " + name + " is added.");
    } catch (SQLException e) {
        System.err.println("Error adding user: " + e.getMessage());
        e.printStackTrace();
    }
}

private static void getAllUsers(DataSource dataSource) {
    try(Connection conn = dataSource.getConnection()){
        PreparedStatement getAllUsersStmt = conn.prepareStatement("SELECT * FROM contactsdb.USERS");
        ResultSet resultSet = getAllUsersStmt.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id") + " : " + resultSet.getString("name"));
        }
    }
    catch (SQLException e){
        e.printStackTrace();
    }
}

private static void createTableIfNotExists(DataSource dataSource) {
    try (Connection conn = dataSource.getConnection()) {
        PreparedStatement ps = conn.prepareStatement(
            "CREATE TABLE IF NOT EXISTS contactsdb.USERS (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(255) NOT NULL" +
            ")"
        );
        ps.executeUpdate();
        System.out.println("Table USERS is ready.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private static void createDatabaseIfNotExists(DataSource dataSource) {
    try (Connection conn = dataSource.getConnection()) {
        PreparedStatement ps = conn.prepareStatement(
            "CREATE DATABASE IF NOT EXISTS contactsdb"
        );
        ps.executeUpdate();
        System.out.println("Database contactsdb is ready.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private static boolean userExists(DataSource dataSource, String name) {
    try (Connection conn = dataSource.getConnection()) {
        PreparedStatement ps = conn.prepareStatement(
            "SELECT COUNT(*) FROM contactsdb.USERS WHERE name = ?"
        );
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}