package br.com.opah.broker.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.broker.dto.HotelDTO;
import br.com.opah.broker.services.TravelService;

@RestController
@RequestMapping("/travels")
public class TravelController {

    @Autowired()
    private TravelService travelService;

    @GetMapping
    public List<HotelDTO> getTravelInfo(@RequestParam("cityCode") int cityCode,
            @RequestParam("checkin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkin,
            @RequestParam("checkout") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkout,
            @RequestParam("totalAdults") int totalAdults, @RequestParam("totalChilds") int totalChilds) {
        return this.travelService.getHotels();
    }
}