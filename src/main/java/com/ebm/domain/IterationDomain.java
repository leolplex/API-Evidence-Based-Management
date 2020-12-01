package com.ebm.domain;


import java.time.LocalDateTime;

public class IterationDomain {

    private Integer idDomain;
    private String goalDomain;
    private LocalDateTime startDateDomain;
    private LocalDateTime endDateDomain;
    private String stateDomain;

    public Integer getIdDomain() {
        return idDomain;
    }

    public void setIdDomain(Integer idDomain) {
        this.idDomain = idDomain;
    }

    public String getGoalDomain() {
        return goalDomain;
    }

    public void setGoalDomain(String goalDomain) {
        this.goalDomain = goalDomain;
    }

    public LocalDateTime getStartDateDomain() {
        return startDateDomain;
    }

    public void setStartDateDomain(LocalDateTime startDateDomain) {
        this.startDateDomain = startDateDomain;
    }

    public LocalDateTime getEndDateDomain() {
        return endDateDomain;
    }

    public void setEndDateDomain(LocalDateTime endDateDomain) {
        this.endDateDomain = endDateDomain;
    }

    public String getStateDomain() {
        return stateDomain;
    }

    public void setStateDomain(String stateDomain) {
        this.stateDomain = stateDomain;
    }
}
