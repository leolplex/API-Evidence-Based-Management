package com.ebm.domain;

public class KVAUnrealizedValueDomain {
    private Integer id;
    private String marketShare;
    private String customerSatisfactionGap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(String marketShare) {
        this.marketShare = marketShare;
    }

    public String getCustomerSatisfactionGap() {
        return customerSatisfactionGap;
    }

    public void setCustomerSatisfactionGap(String customerSatisfactionGap) {
        this.customerSatisfactionGap = customerSatisfactionGap;
    }
}
