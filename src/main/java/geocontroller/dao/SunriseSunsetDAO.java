package geocontroller.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import geocontroller.model.SunriseResults;
import org.springframework.web.reactive.function.client.WebClient;

public class SunriseSunsetDAO {
    private static final String BASE_URL = "https://api.sunrisesunset.io";

    public static SunriseResults requestData(float latitude, float longitude) throws JsonProcessingException {
        WebClient webClient  = WebClient.builder().baseUrl(BASE_URL).build();

        String responseBody;
        ObjectMapper mapper = new ObjectMapper();
        SunriseResults object;
        responseBody= webClient
                .get()
                .uri("/json?lat="+latitude+"&lng="+longitude)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        object = mapper.readValue(responseBody, SunriseResults.class);
        return object;
    }
}
