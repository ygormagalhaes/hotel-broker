package br.com.opah.broker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.broker.services.TravelService;

@RestController
public class TravelController {

    @Autowired()
    private TravelService travelService;

    @GetMapping("/travel")
    public String travel() {
        return this.travelService.getTravelInfo();
    }
}