package geocontroller.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import geocontroller.model.CoordinatesResults;
import org.springframework.web.reactive.function.client.WebClient;

public class GeocodingDAO {
    private static final String BASE_URL = "https://geocoding-api.open-meteo.com/v1/search";

    public static CoordinatesResults requestData(String cityName) throws JsonProcessingException {

        WebClient webClient  = WebClient.builder().baseUrl(BASE_URL).build();

      String responseBody;
      ObjectMapper mapper = new ObjectMapper();
      CoordinatesResults object;
      responseBody= webClient
              .get()
              .uri("?name="+cityName+"&count=1")
              .retrieve()
              .bodyToMono(String.class)
              .block();
      object = mapper.readValue(responseBody, CoordinatesResults.class);
      return object;
    }
}
