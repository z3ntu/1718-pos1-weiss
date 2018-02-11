package at.spengergasse.weiss.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class WebTemperatureController {
    @Autowired
    protected WebTemperatureService temperatureService;

    protected Logger logger = Logger.getLogger(WebTemperatureController.class.getName());


    public WebTemperatureController(WebTemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }


    @RequestMapping("/temperature")
    @ResponseBody
    public String goHome() {
        return "temperature call";
    }

    @RequestMapping(value = "/temperature/current", method = RequestMethod.GET)
    @ResponseBody
    public Temperature getCurrent() {
        logger.info(temperatureService.getCurrentTemperature().toString());
//        return new Temperature(1L);
        return temperatureService.getCurrentTemperature();
    }
}
