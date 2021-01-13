package com.ebm.persistence.entity;

import com.ebm.domain.Team;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
public class EntityProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;

    @Column(name = "name")
    private String entityName;

    @Column(name = "start_date")
    private LocalDateTime entityStartDate;

    @Column(name = "id_team")
    private Integer entityIdTeam;

    @Column(name = "id_user")
    private Integer entityIdUser;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_team", referencedColumnName = "id", insertable = false, updatable = false)
    private EntityTeam entityTeam;

    @OneToMany(mappedBy = "entityProduct", cascade = {CascadeType.ALL})
    private List<EntityIterationProduct> entityIterationProducts;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public LocalDateTime getEntityStartDate() {
        return entityStartDate;
    }

    public void setEntityStartDate(LocalDateTime entityStartDate) {
        this.entityStartDate = entityStartDate;
    }

    public Integer getEntityIdTeam() {
        return entityIdTeam;
    }

    public void setEntityIdTeam(Integer entityIdTeam) {
        this.entityIdTeam = entityIdTeam;
    }

    public List<EntityIterationProduct> getEntityIterationProducts() {
        return entityIterationProducts;
    }

    public void setEntityIterationProducts(List<EntityIterationProduct> entityIterationProducts) {
        this.entityIterationProducts = entityIterationProducts;
    }

    public Integer getEntityIdUser() {
        return entityIdUser;
    }

    public void setEntityIdUser(Integer entityIdUser) {
        this.entityIdUser = entityIdUser;
    }

    public EntityTeam getEntityTeam() {
        return entityTeam;
    }

    public void setEntityTeam(EntityTeam entityTeam) {
        this.entityTeam = entityTeam;
    }
}
