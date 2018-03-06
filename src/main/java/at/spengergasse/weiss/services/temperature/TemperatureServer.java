package at.spengergasse.weiss.services.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("at.spengergasse.weiss.temperature")
public class TemperatureServer {
    public static void main(String[] args) {
        // Tell server to look for temperature-server.properties or temperature-server.yml
        System.setProperty("spring.config.name", "temperature-server");
        System.setProperty("spring.application.name", "temperature-server");

        SpringApplication.run(TemperatureServer.class, args);
    }
}
