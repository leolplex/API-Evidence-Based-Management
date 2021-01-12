package com.ebm.domain.dto;

public class AuthenticationResponse {
    private Integer id;
    private String jwt;
    private String userName;

    public AuthenticationResponse(Integer id, String jwt, String userName) {
        this.id = id;
        this.jwt = jwt;
        this.userName = userName;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
