package com.ebm.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "kva_unrealized_value")
public class EntityKVAUnrealizedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;
    @Column(name = "market_share")
    private String entityMarketShare;
    @Column(name = "customer_or_user_satisfaction_gap")
    private String entityCustomerSatisfactionGap;
    @Column(name = "id_iteration")
    private Integer entityIdIteration;
    @Column(name = "id_team")
    private Integer entityIdTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_iteration", referencedColumnName = "id", insertable = false, updatable = false)
    private EntityIteration entityIteration;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityMarketShare() {
        return entityMarketShare;
    }

    public void setEntityMarketShare(String entityMarketShare) {
        this.entityMarketShare = entityMarketShare;
    }

    public String getEntityCustomerSatisfactionGap() {
        return entityCustomerSatisfactionGap;
    }

    public void setEntityCustomerSatisfactionGap(String entityCustomerSatisfactionGap) {
        this.entityCustomerSatisfactionGap = entityCustomerSatisfactionGap;
    }

    public EntityIteration getEntityIteration() {
        return entityIteration;
    }

    public void setEntityIteration(EntityIteration entityIteration) {
        this.entityIteration = entityIteration;
    }

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
