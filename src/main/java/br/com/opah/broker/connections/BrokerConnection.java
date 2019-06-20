package br.com.opah.broker.connections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.opah.broker.dto.HotelDTO;

@Component
public class BrokerConnection {

    @Autowired
    private Environment env;

    public List<HotelDTO> getHotels(int cityId) {
        String apiUrl = this.env.getProperty("broker.api");
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
            .path(this.env.getProperty("broker.api.hotels.path"))
            .path(Integer.toString(cityId));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<HotelDTO>> responseEntity =
            restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<HotelDTO>>() {
            });
        return responseEntity.getBody();
    }

}