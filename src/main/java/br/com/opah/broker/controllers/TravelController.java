package br.com.opah.broker.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.broker.dto.TravelDTO;
import br.com.opah.broker.services.TravelService;

@RestController
@RequestMapping(value = "/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public List<TravelDTO> getTravelOptions(@RequestParam("cityCode") int cityCode,
            @RequestParam("checkin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkin,
            @RequestParam("checkout") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkout,
            @RequestParam("totalAdults") int totalAdults, @RequestParam("totalChilds") int totalChilds) {
        return this.travelService.getTravelOptions(cityCode, checkin, checkout, totalAdults, totalChilds);
    }

    @GetMapping("/hotels/{hotelId}")
    public TravelDTO getTravelInfoForHotel(@PathVariable int hotelId,
            @RequestParam("checkin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkin,
            @RequestParam("checkout") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkout,
            @RequestParam("totalAdults") int totalAdults, @RequestParam("totalChilds") int totalChilds) {
        return this.travelService.getTravelForHotel(checkin, checkout, totalAdults, totalChilds, hotelId);
    }

}
