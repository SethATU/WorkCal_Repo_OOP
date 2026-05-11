package ie.atu.oop_project.Service;

import ie.atu.oop_project.Model.User;
import ie.atu.oop_project.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    private UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        userRepo.save(user);
        return user;
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User with id " + id + " not found");
        }
        userRepo.deleteById(id);
    }
}
