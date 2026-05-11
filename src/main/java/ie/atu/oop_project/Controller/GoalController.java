package ie.atu.oop_project.Controller;

import ie.atu.oop_project.Model.Goal;
import ie.atu.oop_project.Service.GoalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<?> createGoal(@Valid @RequestBody Goal goal){
        return ResponseEntity.status(HttpStatus.CREATED).body(goalService.createGoal(goal));
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<?> getGoalById(@PathVariable long id){
        return ResponseEntity.ok(goalService.getGoaById(id));
    }

    @GetMapping("/findUserId/{userId}")
    public ResponseEntity<List<Goal>> getGoalByUserId(@PathVariable long userId){
        return ResponseEntity.ok(goalService.getGoalByUserId(userId));
    }

    @GetMapping("/allGoals")
    public ResponseEntity<List<Goal>> getAllGoals(){
        return ResponseEntity.ok(goalService.getAllGoals());
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<?> deleteGoalById(@PathVariable long id){
        goalService.getGoaById(id);
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
}
