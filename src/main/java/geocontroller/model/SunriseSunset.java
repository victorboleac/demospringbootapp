package geocontroller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SunriseSunset (String sunrise, String sunset) {
}
