package com.ebm.domain;

public class KVATimeToMarket {

    private Integer id;
    private String buildAndIntegrationFrequency;
    private String releaseFrequency;
    private String releaseStabilizationPeriod;
    private String meanTimeToRepair;
    private String cycleTime;
    private String leadTime;
    private String timeToLearn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildAndIntegrationFrequency() {
        return buildAndIntegrationFrequency;
    }

    public void setBuildAndIntegrationFrequency(String buildAndIntegrationFrequency) {
        this.buildAndIntegrationFrequency = buildAndIntegrationFrequency;
    }

    public String getReleaseFrequency() {
        return releaseFrequency;
    }

    public void setReleaseFrequency(String releaseFrequency) {
        this.releaseFrequency = releaseFrequency;
    }

    public String getReleaseStabilizationPeriod() {
        return releaseStabilizationPeriod;
    }

    public void setReleaseStabilizationPeriod(String releaseStabilizationPeriod) {
        this.releaseStabilizationPeriod = releaseStabilizationPeriod;
    }

    public String getMeanTimeToRepair() {
        return meanTimeToRepair;
    }

    public void setMeanTimeToRepair(String meanTimeToRepair) {
        this.meanTimeToRepair = meanTimeToRepair;
    }

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    public String getTimeToLearn() {
        return timeToLearn;
    }

    public void setTimeToLearn(String timeToLearn) {
        this.timeToLearn = timeToLearn;
    }
}
