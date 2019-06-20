package br.com.opah.broker.dto;

import java.util.ArrayList;
import java.util.List;

public class TravelDTO {

    private int id;
    private String cityName;
    private List<TravelRoom> rooms = new ArrayList<>();

    public TravelDTO(int id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setRooms(List<TravelRoom> rooms) {
        this.rooms = rooms;
    }

    public List<TravelRoom> getRooms() {
        return rooms;
    }
}