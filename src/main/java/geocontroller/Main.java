package geocontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import geocontroller.model.GeocodingDAO;

public class Main {
    public static void main(String[] args) {
        try {
            Results testResults = GeocodingDAO.requestData("London");
            System.out.println(testResults);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
