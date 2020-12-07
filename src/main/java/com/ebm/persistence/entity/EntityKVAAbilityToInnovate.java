package com.ebm.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "kva_ability_to_innovate")
public class EntityKVAAbilityToInnovate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;

    @Column(name = "feature_usage_index")
    private String entityFeatureUsageIndex;

    @Column(name = "innovation_rate")
    private String entityInnovationRate;

    @Column(name = "defect_trends")
    private String entityDefectTrends;

    @Column(name = "on_product_index")
    private String entityOnProductIndex;

    @Column(name = "installed_version_index")
    private String entityInstalledVersionIndex;

    @Column(name = "technical_debt")
    private String entityTechnicalDebt;

    @Column(name = "production_incident_trends")
    private String entityProductionIncidentTrends;

    @Column(name = "active_code_branches_time_spent_merging_code_between_branches")
    private String entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches;

    @Column(name = "time_spent_context_switching")
    private String entityTimeSpentContextSwitching;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_iteration", referencedColumnName = "id")
    private EntityIteration entityIteration;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityFeatureUsageIndex() {
        return entityFeatureUsageIndex;
    }

    public void setEntityFeatureUsageIndex(String entityFeatureUsageIndex) {
        this.entityFeatureUsageIndex = entityFeatureUsageIndex;
    }

    public String getEntityInnovationRate() {
        return entityInnovationRate;
    }

    public void setEntityInnovationRate(String entityInnovationRate) {
        this.entityInnovationRate = entityInnovationRate;
    }

    public String getEntityDefectTrends() {
        return entityDefectTrends;
    }

    public void setEntityDefectTrends(String entityDefectTrends) {
        this.entityDefectTrends = entityDefectTrends;
    }

    public String getEntityOnProductIndex() {
        return entityOnProductIndex;
    }

    public void setEntityOnProductIndex(String entityOnProductIndex) {
        this.entityOnProductIndex = entityOnProductIndex;
    }

    public String getEntityInstalledVersionIndex() {
        return entityInstalledVersionIndex;
    }

    public void setEntityInstalledVersionIndex(String entityInstalledVersionIndex) {
        this.entityInstalledVersionIndex = entityInstalledVersionIndex;
    }

    public String getEntityTechnicalDebt() {
        return entityTechnicalDebt;
    }

    public void setEntityTechnicalDebt(String entityTechnicalDebt) {
        this.entityTechnicalDebt = entityTechnicalDebt;
    }

    public String getEntityProductionIncidentTrends() {
        return entityProductionIncidentTrends;
    }

    public void setEntityProductionIncidentTrends(String entityProductionIncidentTrends) {
        this.entityProductionIncidentTrends = entityProductionIncidentTrends;
    }

    public String getEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches() {
        return entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches;
    }

    public void setEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(String entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches) {
        this.entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches = entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches;
    }

    public String getEntityTimeSpentContextSwitching() {
        return entityTimeSpentContextSwitching;
    }

    public void setEntityTimeSpentContextSwitching(String entityTimeSpentContextSwitching) {
        this.entityTimeSpentContextSwitching = entityTimeSpentContextSwitching;
    }

    public EntityIteration getEntityIteration() {
        return entityIteration;
    }

    public void setEntityIteration(EntityIteration entityIteration) {
        this.entityIteration = entityIteration;
    }
}
