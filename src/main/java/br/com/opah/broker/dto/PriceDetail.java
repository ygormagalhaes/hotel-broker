package br.com.opah.broker.dto;

import java.math.BigDecimal;

public class PriceDetail {

    private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;

    public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
        this.pricePerDayAdult = pricePerDayAdult;
    }

    public BigDecimal getPricePerDayAdult() {
        return pricePerDayAdult;
    }

    public void setPricePerDayChild(BigDecimal pricePerDayChild) {
        this.pricePerDayChild = pricePerDayChild;
    }

    public BigDecimal getPricePerDayChild() {
        return pricePerDayChild;
    }
}