package at.spengergasse.weiss.services.temperature;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RefreshScope
public class TemperatureController {

    private final TemperatureService temperatureService;

    protected Logger logger = Logger.getLogger(TemperatureController.class.getName());

    @Value("${message:default}")
    private String message;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @RequestMapping("/temperature/current")
    public Temperature getCurrentTemperature() {
        logger.info("getCurrentTemperature() invoked");
        return new Temperature(temperatureService.getCurrentTemperature());
    }

    @RequestMapping("/temperature/test")
    public Test getTest() {
        logger.info("getTest() invoked");
        return new Test(message);
    }
}
