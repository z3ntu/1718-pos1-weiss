package at.spengergasse.s_w.services.temperature;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private static Random random = new Random();

    @Override
    public double getCurrentTemperature() {
        // Return a random double between -25 and 25 with 2 comma digits (e.g. -10.94 or 24.18)
        return (random.nextInt(5000) - 2500) / 100.0;
    }
}
