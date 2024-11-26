package geocontroller.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import geocontroller.dao.SunriseSunsetDAO;
import geocontroller.model.CoordinatesResults;
import geocontroller.dao.GeocodingDAO;
import geocontroller.model.SunriseResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class GeoController {
    @GetMapping("/get-coordinates")
    public String getCoordinates(@RequestParam String cityName) throws JsonProcessingException {
        CoordinatesResults testCoordinatesResults = GeocodingDAO.requestData(cityName);
        return "Longitude: "+ testCoordinatesResults.results().getFirst().longitude()+
                "\nLatitude: "+ testCoordinatesResults.results().getFirst().latitude();
    }

    @GetMapping("/get-sunrise-and-sunset")
    public String getSunriseAndSunset(@RequestParam float latitude, float longitude) throws JsonProcessingException {
        SunriseResults testCoordinatesResults = SunriseSunsetDAO.requestData(latitude, longitude);
        return "Sunrise is at: "+testCoordinatesResults.results().sunrise()+
                "\nSunset is: "+testCoordinatesResults.results().sunset();
    }
}
