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
    }

    @Test
    void getAndSetId() {
        // Arrange
        final Integer id = 42;

        //Act
        tester.setId(id);
        final Integer getId = tester.getId();

        // Assert
        assertEquals(id, getId, "setId must be my 42");
    }

    @Test
    void getAndSetBuildAndIntegrationFrequency() {
        // Arrange
        final String buildAndIntegrationFrequency = "10 by week";

        //Act
        tester.setBuildAndIntegrationFrequency(buildAndIntegrationFrequency);
        final String getBuildAndIntegrationFrequency = tester.getBuildAndIntegrationFrequency();

        // Assert
        assertEquals(buildAndIntegrationFrequency, getBuildAndIntegrationFrequency, "setBuildAndIntegrationFrequency must be 10 by week");
    }

    @Test
    void getAndSetReleaseFrequency() {
        // Arrange
        final String releaseFrequency = "Monthly";

        //Act
        tester.setReleaseFrequency(releaseFrequency);
        final String getReleaseFrequency = tester.getReleaseFrequency();

        // Assert
        assertEquals(releaseFrequency, getReleaseFrequency, "setReleaseFrequency must be Monthly");
    }

    @Test
    void getAndSetReleaseStabilizationPeriod() {
        // Arrange
        final String releaseStabilizationPeriod = "3 days";

        //Act
        tester.setReleaseStabilizationPeriod(releaseStabilizationPeriod);
        final String getReleaseStabilizationPeriod = tester.getReleaseStabilizationPeriod();

        // Assert
        assertEquals(releaseStabilizationPeriod, getReleaseStabilizationPeriod, "setReleaseStabilizationPeriod must be 3 days");
    }

    @Test
    void getAndSetMeanTimeToRepair() {
        // Arrange
        final String meanTimeToRepair = "3/5";

        //Act
        tester.setMeanTimeToRepair(meanTimeToRepair);
        final String getMeanTimeToRepair = tester.getMeanTimeToRepair();

        // Assert
        assertEquals(meanTimeToRepair, getMeanTimeToRepair, "setMeanTimeToRepair must be 3/5");
    }

    @Test
    void getAndSetCycleTime() {
        // Arrange
        final String cycleTime = "1 month";

        //Act
        tester.setCycleTime(cycleTime);
        final String getCycleTime = tester.getCycleTime();

        // Assert
        assertEquals(cycleTime, getCycleTime, "setCycleTime must be 1 month");
    }

    @Test
    void getAndSetLeadTime() {
        // Arrange
        final String leadTime = "3 months";

        //Act
        tester.setLeadTime(leadTime);
        final String getLeadTime = tester.getLeadTime();

        // Assert
        assertEquals(leadTime, getLeadTime, "setLeadTime must be 3 months");
    }

    @Test
    void getAndSetTimeToLearn() {
        // Arrange
        final String timeToLearn = "1 month";

        //Act
        tester.setTimeToLearn(timeToLearn);
        final String getTimeToLearn = tester.getTimeToLearn();

        // Assert
        assertEquals(timeToLearn, getTimeToLearn, "setTimeToLearn must be 1 month");
    }

}
