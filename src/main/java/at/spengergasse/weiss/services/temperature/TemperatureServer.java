package at.spengergasse.weiss.services.temperature;

import at.spengergasse.weiss.temperature.TemperatureConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;


@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(TemperatureConfiguration.class)
public class TemperatureServer {

//    @Autowired
//    protected TemperatureRepository temperatureRepository;

    protected Logger logger = Logger.getLogger(TemperatureServer.class.getName());

    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "temperature-server");

        SpringApplication.run(TemperatureServer.class, args);
    }
}
