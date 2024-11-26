import com.fasterxml.jackson.core.JsonProcessingException;
import geocontroller.dao.GeocodingDAO;
import geocontroller.dao.SunriseSunsetDAO;
import geocontroller.model.CoordinatesResults;
import geocontroller.model.SunriseResults;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the city for which you want to get the Sunrise and Sunset time: ");
        String cityName = scanner.nextLine();

        CoordinatesResults testCoordinatesResults = GeocodingDAO.requestData(cityName);

        float latitude = testCoordinatesResults.results().getFirst().latitude();
        float longitude = testCoordinatesResults.results().getFirst().longitude();

        SunriseResults sunriseSunsetResults = SunriseSunsetDAO.requestData(latitude, longitude);
        String sunrise = sunriseSunsetResults.results().sunrise();
        String sunset = sunriseSunsetResults.results().sunset();

        System.out.println("Sunrise: " + sunrise+ " Sunset: " + sunset);

    }
}
