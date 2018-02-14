package at.spengergasse.weiss.services.web;

import at.spengergasse.weiss.temperature.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class WebTemperatureController {

    protected WebTemperatureService webTemperatureService;

    protected Logger logger = Logger.getLogger(WebTemperatureController.class.getName());

    @Autowired
    public WebTemperatureController(WebTemperatureService webTemperatureService) {
        this.webTemperatureService = webTemperatureService;
    }

    @RequestMapping("/temperature")
    public String goHome() {
        return "temperature call";
    }

    @RequestMapping(value = "/temperature/current")
    public Temperature getCurrent() {
        return webTemperatureService.getCurrentTemperature();
    }
}
