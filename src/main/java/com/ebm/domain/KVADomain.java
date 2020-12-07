package com.ebm.domain;

public class KVADomain {
    private KVAUnrealizedValueDomain kvaUnrealizedValue;
    private  KVACurrentValue kvaCurrentValue;

    public KVAUnrealizedValueDomain getKvaUnrealizedValue() {
        return kvaUnrealizedValue;
    }

    public void setKvaUnrealizedValue(KVAUnrealizedValueDomain kvaUnrealizedValue) {
        this.kvaUnrealizedValue = kvaUnrealizedValue;
    }

    public KVACurrentValue getKvaCurrentValue() {
        return kvaCurrentValue;
    }

    public void setKvaCurrentValue(KVACurrentValue kvaCurrentValue) {
        this.kvaCurrentValue = kvaCurrentValue;
    }
}
