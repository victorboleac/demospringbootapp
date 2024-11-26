package geocontroller.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import geocontroller.Results;
import geocontroller.model.GeocodingDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class GeoController {
    @GetMapping("/get-coordinates")
    public String getCoordinates(@RequestParam String cityName) throws JsonProcessingException {
        Results testResults = GeocodingDAO.requestData(cityName);
        return testResults.results().getFirst().toString();
    }

}
