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

    @Test
    public void travelBusinessDefined() {
        assertThat(this.travelBusiness).isNotNull();
    }

    @Test(expected = TravelException.class)
    public void travelBusinessMustThrowErrorWithNullHotelsList() {
        List<HotelDTO> hotels = null;
        this.travelBusiness.getTravelInfoForHotels(hotels);
    }
}