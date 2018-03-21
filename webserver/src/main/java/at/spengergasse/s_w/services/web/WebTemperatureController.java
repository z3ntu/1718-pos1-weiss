package at.spengergasse.s_w.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.logging.Logger;

@Controller
public class WebTemperatureController {

    protected WebTemperatureService webTemperatureService;

    protected Logger logger = Logger.getLogger(WebTemperatureController.class.getName());

    @Autowired
    public WebTemperatureController(WebTemperatureService webTemperatureService) {
        this.webTemperatureService = webTemperatureService;
    }

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        Temperature temperature = webTemperatureService.getCurrentTemperature();

        model.put("temperature", temperature.getTemperature());
        model.put("success", temperature.isSuccess());
        return "temperature";
    }
}
