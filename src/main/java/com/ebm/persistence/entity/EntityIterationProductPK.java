package com.ebm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EntityIterationProductPK implements Serializable {

    @Column(name = "id_iteration")
    private  Integer idIteration;

    @Column(name = "id_product")
    private  Integer idProduct;

    public Integer getIdIteration() {
        return idIteration;
    }

    public void setIdIteration(Integer idIteration) {
        this.idIteration = idIteration;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
