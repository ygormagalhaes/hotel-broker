package br.com.opah.broker.business;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.exceptions.TravelException;

@Service
public class TravelBusiness {

    public void getTravelInfoForHotels(List<HotelDTO> hotels) {
        if (hotels == null) {
            throw new TravelException(TravelException.NULL_HOTELS_LIST);
        }
    }
}
