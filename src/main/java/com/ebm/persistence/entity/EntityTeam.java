package com.ebm.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "team")
public class EntityTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;

    @Column(name = "name")
    private String entityName;

    @Column(name = "date_join")
    private LocalDateTime entityDateJoin;


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

    public LocalDateTime getEntityDateJoin() {
        return entityDateJoin;
    }

    public void setEntityDateJoin(LocalDateTime entityDateJoin) {
        this.entityDateJoin = entityDateJoin;
    }


}
