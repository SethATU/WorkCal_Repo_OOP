package ie.atu.oop_project.Service;

import ie.atu.oop_project.Model.Log;
import ie.atu.oop_project.Repository.LogRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepo logRepo;

    private LogService(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    public Log createLog(Log log) {
        return logRepo.save(log);
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
}
