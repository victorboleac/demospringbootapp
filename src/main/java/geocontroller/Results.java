package geocontroller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import geocontroller.model.CityCoordinates;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(List<CityCoordinates> results) {
}
