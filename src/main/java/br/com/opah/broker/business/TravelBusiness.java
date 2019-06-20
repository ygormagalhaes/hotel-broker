package br.com.opah.broker.business;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.dto.PriceDetail;
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
                BigDecimal totalPriceAdult = this.getTotalPricePerGuestType(totalAdults, totalDays, room.getPrice().getAdult());
                BigDecimal totalPriceChild = this.getTotalPricePerGuestType(totalChilds, totalDays, room.getPrice().getChild());

                TravelRoom travelRoom = new TravelRoom(room.getRoomID(), room.getCategoryName());
                travelRoom.setTotalPrice(totalPriceAdult.add(totalPriceChild));
                travelRoom.setPriceDetail(new PriceDetail(
                    this.getPricePerDayGuestType(totalAdults, room.getPrice().getAdult()),
                    this.getPricePerDayGuestType(totalChilds, room.getPrice().getChild())));
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

    private BigDecimal getPricePerDayGuestType(int totalGuests, BigDecimal guestTypePrice) {
        return this.getTotalPricePerGuestType(totalGuests, 1, guestTypePrice);
    }

    private BigDecimal getTotalPricePerGuestType(int totalGuests, long totalDays, BigDecimal guestTypePrice) {
        return guestTypePrice.multiply(new BigDecimal(totalGuests * totalDays)).multiply(new BigDecimal(1.7));
    }
}
