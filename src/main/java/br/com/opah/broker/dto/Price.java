package br.com.opah.broker.dto;

import java.math.BigDecimal;

public class Price {

    private BigDecimal adult;
    private BigDecimal child;

    public void setAdult(BigDecimal adult) {
        this.adult = adult;
    }

    public BigDecimal getAdult() {
        return adult;
    }

    public void setChild(BigDecimal child) {
        this.child = child;
    }

    public BigDecimal getChild() {
        return child;
    }

}
