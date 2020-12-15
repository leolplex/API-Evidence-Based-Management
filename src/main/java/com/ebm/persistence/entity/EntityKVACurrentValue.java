package com.ebm.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "kva_current_value")
public class EntityKVACurrentValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;

    @Column(name = "revenue_per_employee")
    private String entityRevenuePerEmployee;

    @Column(name = "product_cost_ratio")
    private String entityProductCostRatio;

    @Column(name = "employee_satisfaction")
    private String entityEmployeeSatisfaction;

    @Column(name = "customer_satisfaction")
    private String entityCustomerSatisfaction;

    @Column(name = "customer_usage_index")
    private String entityCustomerUsageIndex;

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

    public String getEntityRevenuePerEmployee() {
        return entityRevenuePerEmployee;
    }

    public void setEntityRevenuePerEmployee(String entityRevenuePerEmployee) {
        this.entityRevenuePerEmployee = entityRevenuePerEmployee;
    }

    public String getEntityProductCostRatio() {
        return entityProductCostRatio;
    }

    public void setEntityProductCostRatio(String entityProductCostRatio) {
        this.entityProductCostRatio = entityProductCostRatio;
    }

    public String getEntityEmployeeSatisfaction() {
        return entityEmployeeSatisfaction;
    }

    public void setEntityEmployeeSatisfaction(String entityEmployeeSatisfaction) {
        this.entityEmployeeSatisfaction = entityEmployeeSatisfaction;
    }

    public String getEntityCustomerSatisfaction() {
        return entityCustomerSatisfaction;
    }

    public void setEntityCustomerSatisfaction(String entityCustomerSatisfaction) {
        this.entityCustomerSatisfaction = entityCustomerSatisfaction;
    }

    public String getEntityCustomerUsageIndex() {
        return entityCustomerUsageIndex;
    }

    public void setEntityCustomerUsageIndex(String entityCustomerUsageIndex) {
        this.entityCustomerUsageIndex = entityCustomerUsageIndex;
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

    public EntityIteration getEntityIteration() {
        return entityIteration;
    }

    public void setEntityIteration(EntityIteration entityIteration) {
        this.entityIteration = entityIteration;
    }
}
