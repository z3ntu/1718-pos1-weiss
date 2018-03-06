package at.spengergasse.weiss.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class WebServer {

    public static final String TEMPERATURE_SERVICE_URL = "http://TEMPERATURE-SERVICE";

    public static void main(String[] args) {
        // Tell server to look for web-server.properties or web-server.yml
        System.setProperty("spring.config.name", "web-server");
        System.setProperty("spring.application.name", "web-server");

        SpringApplication.run(WebServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebTemperatureService temperatureService() {
        return new WebTemperatureService(TEMPERATURE_SERVICE_URL);
    }

    @Bean
    public WebTemperatureController temperatureController() {
        return new WebTemperatureController(temperatureService());
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }
}
