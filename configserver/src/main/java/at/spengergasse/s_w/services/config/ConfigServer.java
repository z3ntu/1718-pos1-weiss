package at.spengergasse.s_w.services.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
    public static void main(String[] args) {
        // Tell server to look for config-server.properties or config-server.yml
        System.setProperty("spring.config.name", "config-server");

        SpringApplication.run(ConfigServer.class, args);
    }
}
