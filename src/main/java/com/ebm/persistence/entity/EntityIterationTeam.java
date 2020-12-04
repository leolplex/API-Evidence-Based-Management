package com.ebm.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="iteration_team")
public class EntityIterationTeam {
    @EmbeddedId
    private EntityIterationTeamPK entityId;

    @ManyToOne
    @MapsId("entityId")
    @JoinColumn(name = "id_iteration", insertable = false, updatable = false)
    private EntityIteration entityIteration;


    @ManyToOne
    @JoinColumn(name = "id_team", insertable = false, updatable = false)
    private EntityTeam entityTeam;


    public EntityIterationTeamPK getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityIterationTeamPK entityId) {
        this.entityId = entityId;
    }

    public EntityIteration getEntityIteration() {
        return entityIteration;
    }

    public void setEntityIteration(EntityIteration entityIteration) {
        this.entityIteration = entityIteration;
    }

    public EntityTeam getEntityTeam() {
        return entityTeam;
    }

    public void setEntityTeam(EntityTeam entityTeam) {
        this.entityTeam = entityTeam;
    }

}
