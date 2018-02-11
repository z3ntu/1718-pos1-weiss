package at.spengergasse.weiss.temperature;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ComponentScan
@EntityScan("at.spengergasse.weiss.temperature")
//@EnableJpaRepositories("at.spengergasse.weiss.temperature")
public class TemperatureConfiguration {
    protected Logger logger = Logger.getLogger(TemperatureConfiguration.class.getName());
}
