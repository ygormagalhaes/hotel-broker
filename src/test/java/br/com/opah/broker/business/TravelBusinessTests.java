/*
package br.com.opah.broker.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.exceptions.TravelException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelBusinessTests {

    @Autowired
    private TravelBusiness travelBusiness;

    private List<HotelDTO> hotels;

    @Before
    public void beforeTests() {
        this.hotels = new ArrayList<HotelDTO>();
        HotelDTO firstHotel = new HotelDTO();
        firstHotel.setId(1);
        firstHotel.setCityCode(123);
        firstHotel.setName("First Hotel");
        firstHotel.setRooms(new ArrayList<>().addAll());
        this.hotels.add()
    }
    // TODO: Implementar testes

    @Test
    public void travelBusinessDefined() {
        assertThat(this.travelBusiness).isNotNull();
    }

    @Test(expected = TravelException.class)
    public void travelBusinessMustThrowErrorWithNullHotelsList() {
        this.hotels = null;
        this.travelBusiness.getTravelInfoForHotels(hotels);
    }
}
*/