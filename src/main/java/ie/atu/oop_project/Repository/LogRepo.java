package ie.atu.oop_project.Repository;

import ie.atu.oop_project.Model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<Log,Long> {
    List<Log> findByUserId(Long userId);
}
