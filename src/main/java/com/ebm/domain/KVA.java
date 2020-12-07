package com.ebm.domain;

public class KVA {
    private KVAUnrealizedValue kvaUnrealizedValue;
    private  KVACurrentValue kvaCurrentValue;

    public KVAUnrealizedValue getKvaUnrealizedValue() {
        return kvaUnrealizedValue;
    }

    public void setKvaUnrealizedValue(KVAUnrealizedValue kvaUnrealizedValue) {
        this.kvaUnrealizedValue = kvaUnrealizedValue;
    }

    public KVACurrentValue getKvaCurrentValue() {
        return kvaCurrentValue;
    }

    public void setKvaCurrentValue(KVACurrentValue kvaCurrentValue) {
        this.kvaCurrentValue = kvaCurrentValue;
    }
}
