package at.spengergasse.s_w.services.web;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Temperature")
public class Temperature {
    private double temperature;
    private boolean success;
}
