package br.com.opah.broker.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opah.broker.business.TravelBusiness;
import br.com.opah.broker.connections.BrokerConnection;
import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.dto.TravelDTO;

@Service
public class TravelService {

    @Autowired
    private BrokerConnection brokerConnection;

    @Autowired
    private TravelBusiness travelBusinnes;

    public List<TravelDTO> getHotels(int cityCode, Date checkin, Date checkout, int totalAdults, int totalChilds) {
        List<HotelDTO> hotels = this.brokerConnection.getHotels(cityCode);
        return this.travelBusinnes.getTravelInfoForHotels(hotels, checkin, checkout, totalAdults, totalChilds);
    }
}