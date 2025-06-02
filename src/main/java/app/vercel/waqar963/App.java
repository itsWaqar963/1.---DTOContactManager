package app.vercel.waqar963;

import app.vercel.waqar963.config.DatabaseConfig;
import app.vercel.waqar963.dto.UserDTO;
import app.vercel.waqar963.repository.UserRepository;
import app.vercel.waqar963.service.UserService;

import javax.sql.DataSource;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseConfig.getDataSource();

        // Setup
        UserRepository userRepository = new UserRepository(dataSource);
        UserService userService = new UserService(userRepository);

        // Operations
        userService.addUser("Hijab-e-Zahra");
        userService.updateUser(1, "Waqar Ahmed");
        userService.deleteUser("Waqar Ahmed");

        List<UserDTO> users = userService.getAllUsers();
        users.forEach(user ->
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName())
        );
    }
}
