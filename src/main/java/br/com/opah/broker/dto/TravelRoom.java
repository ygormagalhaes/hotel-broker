package br.com.opah.broker.dto;

import java.math.BigDecimal;

public class TravelRoom {

    private int roomID;
    private String categoryName;
    private BigDecimal totalPrice;
    private PriceDetail priceDetail;

    public TravelRoom(int roomID, String categoryName) {
        this.roomID = roomID;
        this.categoryName = categoryName;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setPriceDetail(PriceDetail priceDetail) {
        this.priceDetail = priceDetail;
    }

    public PriceDetail getPriceDetail() {
        return priceDetail;
    }

}