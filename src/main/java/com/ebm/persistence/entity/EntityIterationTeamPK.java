package com.ebm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EntityIterationTeamPK implements Serializable {

    @Column(name = "id_iteration")
    private  Integer idIteration;

    @Column(name = "id_team")
    private  Integer idTeam;

    public Integer getIdIteration() {
        return idIteration;
    }

    public void setIdIteration(Integer idIteration) {
        this.idIteration = idIteration;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }
}
