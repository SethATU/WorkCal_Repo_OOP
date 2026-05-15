package ie.atu.oop_project.client;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url="http://localhost:8081")
public interface UserClient {
    @PostMapping("/login")
    Long userLogin(@RequestBody User user);
}
