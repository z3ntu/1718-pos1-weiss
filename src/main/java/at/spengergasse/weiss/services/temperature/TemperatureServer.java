package at.spengergasse.weiss.services.temperature;

import at.spengergasse.weiss.temperature.TemperatureConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(TemperatureConfiguration.class)
public class TemperatureServer {
    public static void main(String[] args) {
        // Tell server to look for temperature-server.properties or temperature-server.yml
        System.setProperty("spring.config.name", "temperature-server");
        System.setProperty("spring.application.name", "temperature-server");

        SpringApplication.run(TemperatureServer.class, args);
    }
}
