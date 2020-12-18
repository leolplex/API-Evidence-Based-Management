package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KVATimeToMarketTest {
    KVATimeToMarket tester;

    @BeforeEach
    void initEach() {
        tester = new KVATimeToMarket();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getId(), "getIdIteration must be null");
        assertNull(tester.getBuildAndIntegrationFrequency(), "getBuildAndIntegrationFrequency must be null");
        assertNull(tester.getReleaseFrequency(), "getReleaseFrequency must be null");
        assertNull(tester.getReleaseStabilizationPeriod(), "getReleaseStabilizationPeriod must be null");
        assertNull(tester.getMeanTimeToRepair(), "getMeanTimeToRepair must be null");
        assertNull(tester.getCycleTime(), "getCycleTime must be null");
        assertNull(tester.getLeadTime(), "getLeadTime must be null");
        assertNull(tester.getTimeToLearn(), "getTimeToLearn must be null");
        assertNull(tester.getIdTeam(), "getIdTeam must be null");
        assertNull(tester.getIdIteration(), "getIdIteration must be null");
    }

    @Test
    void getAndSetId() {
        // Arrange
        final Integer id = 42;
        final String buildAndIntegrationFrequency = "10 by week";
        final String releaseFrequency = "Monthly";
        final String releaseStabilizationPeriod = "3 days";
        final String meanTimeToRepair = "3/5";
        final String cycleTime = "1 month";
        final String leadTime = "3 months";
        final String timeToLearn = "1 month";
        final Integer idTeam = 2;
        final Integer idIteration = 6;


        //Act
        tester.setId(id);
        tester.setBuildAndIntegrationFrequency(buildAndIntegrationFrequency);
        tester.setReleaseFrequency(releaseFrequency);
        tester.setReleaseStabilizationPeriod(releaseStabilizationPeriod);
        tester.setMeanTimeToRepair(meanTimeToRepair);
        tester.setCycleTime(cycleTime);
        tester.setLeadTime(leadTime);
        tester.setTimeToLearn(timeToLearn);
        tester.setIdTeam(idTeam);
        tester.setIdIteration(idIteration);



        final Integer getId = tester.getId();
        final String getBuildAndIntegrationFrequency = tester.getBuildAndIntegrationFrequency();
        final String getReleaseFrequency = tester.getReleaseFrequency();
        final String getReleaseStabilizationPeriod = tester.getReleaseStabilizationPeriod();
        final String getMeanTimeToRepair = tester.getMeanTimeToRepair();
        final String getCycleTime = tester.getCycleTime();
        final String getLeadTime = tester.getLeadTime();
        final String getTimeToLearn = tester.getTimeToLearn();
        final Integer getIdIteration = tester.getIdIteration();
        final Integer getIdTeam = tester.getIdTeam();



        // Assert
        assertEquals(id, getId, "setId must be my 42");
        assertEquals(buildAndIntegrationFrequency, getBuildAndIntegrationFrequency, "setBuildAndIntegrationFrequency must be 10 by week");
        assertEquals(releaseFrequency, getReleaseFrequency, "setReleaseFrequency must be Monthly");
        assertEquals(releaseStabilizationPeriod, getReleaseStabilizationPeriod, "setReleaseStabilizationPeriod must be 3 days");
        assertEquals(meanTimeToRepair, getMeanTimeToRepair, "setMeanTimeToRepair must be 3/5");
        assertEquals(cycleTime, getCycleTime, "setCycleTime must be 1 month");
        assertEquals(leadTime, getLeadTime, "setLeadTime must be 3 months");
        assertEquals(timeToLearn, getTimeToLearn, "setTimeToLearn must be 1 month");
        assertEquals(idIteration, getIdIteration, "setIdTeam must be my 2");
        assertEquals(idTeam, getIdTeam, "setIdIteration must be my 6");


    }

}
