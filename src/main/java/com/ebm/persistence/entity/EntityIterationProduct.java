package com.ebm.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="iteration_product")
public class EntityIterationProduct {
    @EmbeddedId
    private EntityIterationProductPK entityId;

    @ManyToOne
    @MapsId("entityId")
    @JoinColumn(name = "id_iteration", insertable = false, updatable = false)
    private EntityIteration entityIteration;


    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private EntityProduct entityProduct;


    public EntityIterationProductPK getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityIterationProductPK entityId) {
        this.entityId = entityId;
    }

    public EntityIteration getEntityIteration() {
        return entityIteration;
    }

    public void setEntityIteration(EntityIteration entityIteration) {
        this.entityIteration = entityIteration;
    }

    public EntityProduct getEntityProduct() {
        return entityProduct;
    }

    public void setEntityProduct(EntityProduct entityProduct) {
        this.entityProduct = entityProduct;
    }

}
