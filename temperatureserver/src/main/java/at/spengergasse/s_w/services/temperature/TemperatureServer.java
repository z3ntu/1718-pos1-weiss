package at.spengergasse.s_w.services.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TemperatureServer {
    public static void main(String[] args) {
        // Tell server to look for temperature-server.properties or temperature-server.yml
        System.setProperty("spring.config.name", "temperature-server");
        System.setProperty("spring.application.name", "temperature-server");

        SpringApplication.run(TemperatureServer.class, args);
    }
}
