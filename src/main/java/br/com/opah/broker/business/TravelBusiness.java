package br.com.opah.broker.business;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.opah.broker.dto.HotelDTO;

@Service
public class TravelBusiness {

    public void getTravelInfoForHotels(List<HotelDTO> hotels) {
        System.out.println("implementar método");
    }
}
