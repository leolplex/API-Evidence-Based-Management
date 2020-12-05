package com.ebm.domain;

import java.time.LocalDateTime;
import java.util.List;

public class TeamDomain {

    private Integer id;
    private String name;
    private LocalDateTime dateJoin;
    private List<IterationDomain> iterations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(LocalDateTime dateJoin) {
        this.dateJoin = dateJoin;
    }

    public List<IterationDomain> getIterations() {
        return iterations;
    }

    public void setIterations(List<IterationDomain> iterations) {
        this.iterations = iterations;
    }

}
