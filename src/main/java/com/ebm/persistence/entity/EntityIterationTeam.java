package com.ebm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "iteration_team")
public class EntityIterationTeam {
    @Column(name = "id_iteration")
    private Integer entityIdIteration;
    @Column(name = "id_team")
    private Integer entityIdTeam;

    public Integer getEntityIdIteration() {
        return entityIdIteration;
    }

    public void setEntityIdIteration(Integer entityIdIteration) {
        this.entityIdIteration = entityIdIteration;
    }

    public Integer getEntityIdTeam() {
        return entityIdTeam;
    }

    public void setEntityIdTeam(Integer entityIdTeam) {
        this.entityIdTeam = entityIdTeam;
    }
}
