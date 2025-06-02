package app.vercel.waqar963.service;

import app.vercel.waqar963.dto.UserDTO;
import app.vercel.waqar963.repository.UserRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    private final UserRepository userRepository;
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String name) {
        if (userRepository.userExists(name)) {
            logger.info("User already exists: " + name);
            return;
        }
        userRepository.addUser(name);
        logger.info("User added: " + name);
    }

    public void deleteUser(String name) {
        if (!userRepository.userExists(name)) {
            logger.warning("User not found: " + name);
            return;
        }
        userRepository.deleteUser(name);
        logger.info("User deleted: " + name);
    }

    public UserDTO updateUser(int id, String newName) {
        if (!userRepository.existsById(id)) {
            logger.warning("User ID not found: " + id);
            return null;
        }
        userRepository.updateUser(id, newName);
        logger.info("User updated: ID=" + id + " to Name=" + newName);
        return new UserDTO(id, newName);
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.getAllUsers();
        logger.info("Fetched " + users.size() + " users");
        return users;
    }
}
