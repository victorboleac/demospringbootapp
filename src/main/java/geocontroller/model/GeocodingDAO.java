package geocontroller.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import geocontroller.Results;
import org.springframework.web.reactive.function.client.WebClient;

public class GeocodingDAO {
    private static final String BASE_URL = "https://geocoding-api.open-meteo.com/v1/search";

    public static Results requestData(String cityName) throws JsonProcessingException {
      WebClient webClient  = WebClient.builder().baseUrl(BASE_URL).build();

      String responseBody;
      ObjectMapper mapper = new ObjectMapper();
      Results object;
      responseBody= webClient
              .get()
              .uri("?name="+cityName+"&count=1")
              .retrieve()
              .bodyToMono(String.class)
              .block();
      object = mapper.readValue(responseBody, Results.class);
      return object;
    }
}
