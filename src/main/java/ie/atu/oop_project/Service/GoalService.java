package ie.atu.oop_project.Service;

import ie.atu.oop_project.Model.Goal;
import ie.atu.oop_project.Repository.GoalRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepo goalRepo;

    private GoalService(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }

    public Goal createGoal(Goal goal) {
        if (goalRepo.existsById(goal.getId())) {
            throw new RuntimeException("Goal already exists!");
        }
        return goalRepo.save(goal);
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
}
