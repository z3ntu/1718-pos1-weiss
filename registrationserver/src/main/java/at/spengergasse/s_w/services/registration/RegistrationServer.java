package at.spengergasse.s_w.services.registration;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
@EnableHystrixDashboard
public class RegistrationServer {
    public static void main(String[] args) {
        // Tell server to look for registration-server.properties or registration-server.yml
        System.setProperty("spring.config.name", "registration-server");
        System.setProperty("spring.application.name", "registration-server");

        SpringApplication.run(RegistrationServer.class, args);
    }
}
