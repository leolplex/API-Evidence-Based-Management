package com.ebm.domain;


import java.time.LocalDateTime;

public class IterationDomain {

    private Integer id;
    private String name;
    private String goal;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String state;

    private KVADomain kva;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public KVADomain getKva() {
        return kva;
    }

    public void setKva(KVADomain kva) {
        this.kva = kva;
    }
}
