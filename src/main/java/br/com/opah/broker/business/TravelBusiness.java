package br.com.opah.broker.business;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.dto.Room;
import br.com.opah.broker.dto.TravelDTO;
import br.com.opah.broker.dto.TravelRoom;

@Component
public class TravelBusiness {

    public List<TravelDTO> getTravelInfoForHotels(List<HotelDTO> hotels, Date checkin, Date checkout, int totalAdults, int totalChilds) {
        List<TravelDTO> travelOptions = new ArrayList<>();
        long totalDays = this.getTotalDays(checkin, checkout);

        for (HotelDTO hotel : hotels) {
            TravelDTO travel = new TravelDTO(hotel.getId(), hotel.getCityName());

            for (Room room : hotel.getRooms()) {
                BigDecimal totalAdult = this.getTotalPriceAdult(totalAdults, totalDays, room.getPrice().getAdult());
                BigDecimal totalChild = this.getTotalPriceChild(totalChilds, totalDays, room.getPrice().getChild());

                TravelRoom travelRoom = new TravelRoom(room.getRoomID(), room.getCategoryName());
                travelRoom.setTotalPrice(totalAdult.add(totalChild));
                travel.getRooms().add(travelRoom);
            }

            travelOptions.add(travel);
        }

        return travelOptions;
    }

    private long getTotalDays(Date checkin, Date checkout) {
        return Duration.between(checkin.toInstant()
            .atZone(ZoneId.systemDefault()), checkout.toInstant().atZone(ZoneId.systemDefault())).toDays();
    }

    private BigDecimal getTotalPriceAdult(int totalAdults, long totalDays, BigDecimal adultPrice) {
        return adultPrice.multiply(new BigDecimal(totalAdults * totalDays)).multiply(new BigDecimal(1.7));
    }

    private BigDecimal getTotalPriceChild(int totalChilds, long totalDays, BigDecimal childPrice) {
        return childPrice.multiply(new BigDecimal(totalChilds * totalDays)).multiply(new BigDecimal(1.7));
    }
}
