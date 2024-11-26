package geocontroller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CityCoordinates(int longitude, int latitude) {
}

