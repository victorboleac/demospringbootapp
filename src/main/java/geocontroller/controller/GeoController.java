package geocontroller.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import geocontroller.dao.SunriseSunsetDAO;
import geocontroller.model.CoordinatesResults;
import geocontroller.dao.GeocodingDAO;
import geocontroller.model.SunriseResults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class GeoController {
    @GetMapping("/get-coordinates")
    public String getCoordinates(@RequestParam String cityName) throws JsonProcessingException {
        CoordinatesResults testCoordinatesResults = GeocodingDAO.requestData(cityName);
        return "Longitude: "+ testCoordinatesResults.results().getFirst().longitude()+
                "\nLatitude: "+ testCoordinatesResults.results().getFirst().latitude();
    }

    @GetMapping("/get-sunrise-and-sunset")
    public String getSunriseAndSunset(@RequestParam String cityName) throws JsonProcessingException {
        CoordinatesResults testCoordinatesResults = GeocodingDAO.requestData(cityName);
        float latitude = testCoordinatesResults.results().getFirst().latitude();
        float longitude = testCoordinatesResults.results().getFirst().longitude();



        SunriseResults sunriseResults = SunriseSunsetDAO.requestData(latitude, longitude);
        String sunrise = sunriseResults.results().sunrise();
        String sunset = sunriseResults.results().sunset();
        return "Sunrise: " + sunrise + " Sunset: " + sunset;
    }
}
