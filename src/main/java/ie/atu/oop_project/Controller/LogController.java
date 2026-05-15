package ie.atu.oop_project.Controller;

import ie.atu.oop_project.Model.Log;
import ie.atu.oop_project.Service.LogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<?> createLog(@Valid @RequestBody Log log, @RequestParam String username, @RequestParam String password){
        Long userId = logService.login(username, password);
        Log newLog = logService.createLog(log,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLog);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<?> getLogById(@PathVariable long id){
        return ResponseEntity.ok(logService.getLogById(id));
    }

    @GetMapping("/findUserId/{userId}")
    public ResponseEntity<List<Log>> getLogByUserId(@PathVariable long userId){
        return ResponseEntity.ok(logService.getLogsByUserId(userId));
    }

    @GetMapping("/allLogs")
    public ResponseEntity<List<Log>> getAllLogs(){
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<?> deleteLogById(@PathVariable long id){
        logService.getLogById(id);
        logService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
