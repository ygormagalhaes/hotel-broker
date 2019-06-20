package br.com.opah.broker.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDTO {

    private int id;
    private String name;
    private int cityCode;
    private List<RoomDTO> rooms;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}