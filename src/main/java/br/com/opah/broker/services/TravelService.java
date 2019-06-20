package br.com.opah.broker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opah.broker.connections.BrokerConnection;
import br.com.opah.broker.dto.HotelDTO;

@Service()
public class TravelService {

    @Autowired()
    private BrokerConnection brokerConnection;

    public List<HotelDTO> getHotels() {
        return this.brokerConnection.getHotels(1);
    }
}