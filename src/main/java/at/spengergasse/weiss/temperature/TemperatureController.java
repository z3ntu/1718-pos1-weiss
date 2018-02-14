package at.spengergasse.weiss.temperature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TemperatureController {

    private final TemperatureService temperatureService;

    protected Logger logger = Logger.getLogger(TemperatureController.class.getName());

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @RequestMapping("/temperature/current")
    public Temperature getCurrentTemperature() {
        logger.info("getCurrentTemperature() invoked");
        return new Temperature(temperatureService.getCurrentTemperature());
    }
}
