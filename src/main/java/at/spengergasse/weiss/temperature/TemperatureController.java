package at.spengergasse.weiss.temperature;

import at.spengergasse.weiss.services.web.Temperature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TemperatureController {
    protected Logger logger = Logger.getLogger(TemperatureController.class.getName());

    @RequestMapping("/temperature/current")
    public Temperature getCurrentTemperature() {
        logger.info("getCurrentTemperature() invoked");
        return new Temperature(21L);
    }
}
