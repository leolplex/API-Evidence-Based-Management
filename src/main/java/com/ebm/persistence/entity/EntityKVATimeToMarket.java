package com.ebm.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "kva_time_to_market")
public class EntityKVATimeToMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;

    @Column(name = "build_and_integration_frequency")
    private String entityBuildAndIntegrationFrequency;

    @Column(name = "release_frequency")
    private String entityReleaseFrequency;

    @Column(name = "release_stabilization_period")
    private String entityReleaseStabilizationPeriod;

    @Column(name = "mean_time_to_repair")
    private String entityMeanTimeToRepair;

    @Column(name = "cycle_time")
    private String entityCycleTime;

    @Column(name = "lead_time")
    private String entityLeadTime;

    @Column(name = "time_to_learn")
    private String entityTimeToLearn;

    @Column(name = "id_team")
    private Integer entityIdTeamT2M;

    @Column(name = "id_iteration")
    private Integer entityIdIterationT2M;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_iteration", referencedColumnName = "id", insertable = false, updatable = false)
    private EntityIteration entityIteration;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityBuildAndIntegrationFrequency() {
        return entityBuildAndIntegrationFrequency;
    }

    public void setEntityBuildAndIntegrationFrequency(String entityBuildAndIntegrationFrequency) {
        this.entityBuildAndIntegrationFrequency = entityBuildAndIntegrationFrequency;
    }

    public String getEntityReleaseFrequency() {
        return entityReleaseFrequency;
    }

    public void setEntityReleaseFrequency(String entityReleaseFrequency) {
        this.entityReleaseFrequency = entityReleaseFrequency;
    }

    public String getEntityReleaseStabilizationPeriod() {
        return entityReleaseStabilizationPeriod;
    }

    public void setEntityReleaseStabilizationPeriod(String entityReleaseStabilizationPeriod) {
        this.entityReleaseStabilizationPeriod = entityReleaseStabilizationPeriod;
    }

    public String getEntityMeanTimeToRepair() {
        return entityMeanTimeToRepair;
    }

    public void setEntityMeanTimeToRepair(String entityMeanTimeToRepair) {
        this.entityMeanTimeToRepair = entityMeanTimeToRepair;
    }

    public String getEntityCycleTime() {
        return entityCycleTime;
    }

    public void setEntityCycleTime(String entityCycleTime) {
        this.entityCycleTime = entityCycleTime;
    }

    public String getEntityLeadTime() {
        return entityLeadTime;
    }

    public void setEntityLeadTime(String entityLeadTime) {
        this.entityLeadTime = entityLeadTime;
    }

    public String getEntityTimeToLearn() {
        return entityTimeToLearn;
    }

    public void setEntityTimeToLearn(String entityTimeToLearn) {
        this.entityTimeToLearn = entityTimeToLearn;
    }

    public EntityIteration getEntityIteration() {
        return entityIteration;
    }

    public void setEntityIteration(EntityIteration entityIteration) {
        this.entityIteration = entityIteration;
    }

    public Integer getEntityIdTeamT2M() {
        return entityIdTeamT2M;
    }

    public void setEntityIdTeamT2M(Integer entityIdTeamT2M) {
        this.entityIdTeamT2M = entityIdTeamT2M;
    }

    public Integer getEntityIdIterationT2M() {
        return entityIdIterationT2M;
    }

    public void setEntityIdIterationT2M(Integer entityIdIterationT2M) {
        this.entityIdIterationT2M = entityIdIterationT2M;
    }
}
