package br.com.opah.broker.connections;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.opah.broker.dto.HotelDTO;

@Service()
public class BrokerConnection {

    // TODO: Ajustar para receber id da cidade.
    private final String HOTELS_API = "https://cvcbackendhotel.herokuapp.com/hotels/avail/1032";

    public List<HotelDTO> getHotels(int cityId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<HotelDTO>> responseEntity =
            restTemplate.exchange(this.HOTELS_API, HttpMethod.GET, null, new ParameterizedTypeReference<List<HotelDTO>>() {
            });
        return responseEntity.getBody();
    }

}