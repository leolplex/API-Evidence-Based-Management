package com.ebm.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class EntityUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;


    @Column(name = "username")
    private String entityUserName;

    @Column(name = "password")
    private String entityPassword;

    @Column(name = "id_rol")
    private Integer entityIdRol;

    @Column(name = "email")
    private String entityEmail;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityUserName() {
        return entityUserName;
    }

    public void setEntityUserName(String entityUserName) {
        this.entityUserName = entityUserName;
    }

    public String getEntityPassword() {
        return entityPassword;
    }

    public void setEntityPassword(String entityPassword) {
        this.entityPassword = entityPassword;
    }

    public Integer getEntityIdRol() {
        return entityIdRol;
    }

    public void setEntityIdRol(Integer entityIdRol) {
        this.entityIdRol = entityIdRol;
    }

    public String getEntityEmail() {
        return entityEmail;
    }

    public void setEntityEmail(String entityEmail) {
        this.entityEmail = entityEmail;
    }
}
