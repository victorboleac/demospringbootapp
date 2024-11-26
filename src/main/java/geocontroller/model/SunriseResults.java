package geocontroller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SunriseResults(List<SunriseResults> sunriseResults) {
}
