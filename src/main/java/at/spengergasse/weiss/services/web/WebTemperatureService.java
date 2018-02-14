package at.spengergasse.weiss.services.web;

import at.spengergasse.weiss.temperature.Temperature;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class WebTemperatureService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    protected Logger logger = Logger.getLogger(WebTemperatureService.class.getName());

    public WebTemperatureService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public Temperature getCurrentTemperature() {
        logger.info("getCurrentTemperature() invoked");
        return restTemplate.getForObject(serviceUrl + "/temperature/current", Temperature.class);
    }

    public Temperature fallbackMethod() {
        return new Temperature(0);
    }
}
