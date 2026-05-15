package ie.atu.oop_project.Service;

import ie.atu.oop_project.Model.Log;
import ie.atu.oop_project.Model.User;
import ie.atu.oop_project.Repository.LogRepo;
import ie.atu.oop_project.client.LoginClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepo logRepo;
    private final LoginClient loginClient;

    private LogService(LogRepo logRepo, LoginClient loginClient) {
        this.logRepo = logRepo;
        this.loginClient = loginClient;
    }

    public Log createLog(Log log, Long userId) {
        log.setUserId(userId);
        logRepo.save(log);
        return log;
    }

    public Log getLogById(Long id) {
        return logRepo.findById(id).orElseThrow(() -> new RuntimeException("Log not found!"));
    }

    public List<Log> getLogsByUserId(Long userId) {
        List<Log> logs = logRepo.findByUserId(userId);
        if (logs.isEmpty()) {
            throw new RuntimeException("Logs not found with userId: " + userId);
        }
        return logs;
    }

    public List<Log> getAllLogs() {
        return logRepo.findAll();
    }

    public void deleteLog(Long id) {
        if (!logRepo.existsById(id)) {
            throw new RuntimeException("Log not found! with id: " + id);
        }
        logRepo.deleteById(id);
    }

    public Long login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return loginClient.loginUser(user);
    }
}
