package br.com.opah.broker.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.services.TravelService;

@RestController
public class TravelController { // TODO: Ajustar path ex.: /api/v1/...

    @Autowired()
    private TravelService travelService;

    @GetMapping("/travel")
    public List<HotelDTO> getTravelInfo(
        @RequestParam("CityCode") int cityCode,
        @RequestParam("Checkin") @DateTimeFormat(pattern = "YYYY-MM-DD") Date checkin) {
        System.out.println(checkin);
        return this.travelService.getHotels();
    }
}