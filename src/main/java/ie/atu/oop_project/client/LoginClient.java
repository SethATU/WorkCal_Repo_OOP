package ie.atu.oop_project.client;

import ie.atu.oop_project.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-service", url="http://localhost:8081")
public interface LoginClient {
    @PostMapping("/auth/login")
    Long loginUser(@RequestBody User user);
}
