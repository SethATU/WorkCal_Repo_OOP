package ie.atu.oop_project.Service;

import ie.atu.oop_project.Model.Goal;
import ie.atu.oop_project.Model.User;
import ie.atu.oop_project.Repository.GoalRepo;
import ie.atu.oop_project.client.LoginClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepo goalRepo;
    private final LoginClient loginClient;

    private GoalService(GoalRepo goalRepo, LoginClient loginClient) {
        this.goalRepo = goalRepo;
        this.loginClient = loginClient;
    }

    public Goal createGoal(Goal goal, Long userId) {
        goal.setUserId(userId);
        goalRepo.save(goal);
        return goal;
    }

    public Goal getGoaById(Long id) {
        return goalRepo.findById(id).orElseThrow(() -> new RuntimeException("Goal not found!"));
    }

    public List<Goal> getGoalByUserId(Long userId) {
        List<Goal> goals = goalRepo.findByUserId(userId);
        if (goals.isEmpty()) {
            throw new RuntimeException("Goals not found with userId: " + userId);
        }
        return goals;
    }

    public List<Goal> getAllGoals() {
        return goalRepo.findAll();
    }

    public void deleteGoal(Long id) {
        if (!goalRepo.existsById(id)) {
            throw new RuntimeException("Goal not found! with id: " + id);
        }
    }

    public Long login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return loginClient.loginUser(user);
    }
}
