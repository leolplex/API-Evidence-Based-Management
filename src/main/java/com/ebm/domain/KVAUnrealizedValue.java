package com.ebm.domain;

public class KVAUnrealizedValue {
    private Integer id;
    private String marketShare;
    private String customerSatisfactionGap;
    private Integer idTeam;
    private Integer idIteration;

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

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public Integer getIdIteration() {
        return idIteration;
    }

    public void setIdIteration(Integer idIteration) {
        this.idIteration = idIteration;
    }
}
