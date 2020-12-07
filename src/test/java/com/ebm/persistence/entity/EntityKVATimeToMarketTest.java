package com.ebm.persistence.entity;

import com.ebm.domain.KVATimeToMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityKVATimeToMarketTest {

    EntityKVATimeToMarket tester;

    @BeforeEach
    void initEach() {
        tester = new EntityKVATimeToMarket();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getEntityId(), "getIdIteration must be null");
        assertNull(tester.getEntityBuildAndIntegrationFrequency(), "getBuildAndIntegrationFrequency must be null");
        assertNull(tester.getEntityReleaseFrequency(), "getReleaseFrequency must be null");
        assertNull(tester.getEntityReleaseStabilizationPeriod(), "getReleaseStabilizationPeriod must be null");
        assertNull(tester.getEntityMeanTimeToRepair(), "getMeanTimeToRepair must be null");
        assertNull(tester.getEntityCycleTime(), "getCycleTime must be null");
        assertNull(tester.getEntityLeadTime(), "getLeadTime must be null");
        assertNull(tester.getEntityTimeToLearn(), "getTimeToLearn must be null");
        assertNull(tester.getEntityIteration(), "getEntityIteration must be null");
    }

    @Test
    void getAndSetEntityId() {
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityId(id);
        final Integer getId = tester.getEntityId();

        // Assert
        assertEquals(id, getId, "setEntityId must be my 42");
    }

    @Test
    void getAndSetEntityBuildAndIntegrationFrequency() {
        // Arrange
        final String buildAndIntegrationFrequency = "10 by week";

        //Act
        tester.setEntityBuildAndIntegrationFrequency(buildAndIntegrationFrequency);
        final String getBuildAndIntegrationFrequency = tester.getEntityBuildAndIntegrationFrequency();

        // Assert
        assertEquals(buildAndIntegrationFrequency, getBuildAndIntegrationFrequency, "setEntityBuildAndIntegrationFrequency must be 10 by week");
    }

    @Test
    void getAndSetEntityReleaseFrequency() {
        // Arrange
        final String releaseFrequency = "Monthly";

        //Act
        tester.setEntityReleaseFrequency(releaseFrequency);
        final String getReleaseFrequency = tester.getEntityReleaseFrequency();

        // Assert
        assertEquals(releaseFrequency, getReleaseFrequency, "setEntityReleaseFrequency must be Monthly");
    }

    @Test
    void getAndSetEntityReleaseStabilizationPeriod() {
        // Arrange
        final String releaseStabilizationPeriod = "3 days";

        //Act
        tester.setEntityReleaseStabilizationPeriod(releaseStabilizationPeriod);
        final String getReleaseStabilizationPeriod = tester.getEntityReleaseStabilizationPeriod();

        // Assert
        assertEquals(releaseStabilizationPeriod, getReleaseStabilizationPeriod, "setEntityReleaseStabilizationPeriod must be 3 days");
    }

    @Test
    void getAndSetEntityMeanTimeToRepair() {
        // Arrange
        final String meanTimeToRepair = "3/5";

        //Act
        tester.setEntityMeanTimeToRepair(meanTimeToRepair);
        final String getMeanTimeToRepair = tester.getEntityMeanTimeToRepair();

        // Assert
        assertEquals(meanTimeToRepair, getMeanTimeToRepair, "setEntityMeanTimeToRepair must be 3/5");
    }

    @Test
    void getAndSetEntityCycleTime() {
        // Arrange
        final String cycleTime = "1 month";

        //Act
        tester.setEntityCycleTime(cycleTime);
        final String getCycleTime = tester.getEntityCycleTime();

        // Assert
        assertEquals(cycleTime, getCycleTime, "setEntityCycleTime must be 1 month");
    }

    @Test
    void getAndSetEntityLeadTime() {
        // Arrange
        final String leadTime = "3 months";

        //Act
        tester.setEntityLeadTime(leadTime);
        final String getLeadTime = tester.getEntityLeadTime();

        // Assert
        assertEquals(leadTime, getLeadTime, "setEntityLeadTime must be 3 months");
    }

    @Test
    void getAndSetEntityTimeToLearn() {
        // Arrange
        final String timeToLearn = "1 month";

        //Act
        tester.setEntityTimeToLearn(timeToLearn);
        final String getTimeToLearn = tester.getEntityTimeToLearn();

        // Assert
        assertEquals(timeToLearn, getTimeToLearn, "setEntityTimeToLearn must be 1 month");
    }

    @Test
    void getAndSetEntityIteration() {
        // Arrange
        final EntityIteration entityIteration = new EntityIteration();

        //Act
        tester.setEntityIteration(entityIteration);
        final EntityIteration getEntityIteration = tester.getEntityIteration();

        // Assert
        assertEquals(entityIteration, getEntityIteration, "setEntityIteration must be new EntityIteration()");
    }
}
