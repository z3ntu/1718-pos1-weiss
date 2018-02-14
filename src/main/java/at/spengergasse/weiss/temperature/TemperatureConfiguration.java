package at.spengergasse.weiss.temperature;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EntityScan("at.spengergasse.weiss.temperature")
public class TemperatureConfiguration {
}
