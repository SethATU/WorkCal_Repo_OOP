package ie.atu.oop_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OopProjectApplication.class, args);
    }

}
