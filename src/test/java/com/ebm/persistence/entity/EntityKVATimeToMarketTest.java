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
        assertNull(tester.getEntityIdTeamT2M(), "getEntityIdTeam must be null");
        assertNull(tester.getEntityIdIterationT2M(), "getEntityIdIteration must be null");
    }

    @Test
    void getAndSetNewObject() {
        // Arrange
        final Integer id = 42;
        final String buildAndIntegrationFrequency = "10 by week";
        final String releaseFrequency = "Monthly";
        final String releaseStabilizationPeriod = "3 days";
        final String meanTimeToRepair = "3/5";
        final String leadTime = "3 months";
        final String cycleTime = "1 month";
        final String timeToLearn = "1 month";
        final EntityIteration entityIteration = new EntityIteration();
        final Integer idTeam = 2;
        final Integer idIteration = 5;


        //Act
        tester.setEntityId(id);
        tester.setEntityBuildAndIntegrationFrequency(buildAndIntegrationFrequency);
        tester.setEntityReleaseFrequency(releaseFrequency);
        tester.setEntityReleaseStabilizationPeriod(releaseStabilizationPeriod);
        tester.setEntityMeanTimeToRepair(meanTimeToRepair);
        tester.setEntityLeadTime(leadTime);
        tester.setEntityCycleTime(cycleTime);
        tester.setEntityTimeToLearn(timeToLearn);
        tester.setEntityIteration(entityIteration);
        tester.setEntityIdTeamT2M(idTeam);
        tester.setEntityIdIterationT2M(idIteration);


        final Integer getId = tester.getEntityId();
        final String getBuildAndIntegrationFrequency = tester.getEntityBuildAndIntegrationFrequency();
        final String getReleaseFrequency = tester.getEntityReleaseFrequency();
        final String getReleaseStabilizationPeriod = tester.getEntityReleaseStabilizationPeriod();
        final String getMeanTimeToRepair = tester.getEntityMeanTimeToRepair();
        final String getLeadTime = tester.getEntityLeadTime();
        final String getCycleTime = tester.getEntityCycleTime();
        final String getTimeToLearn = tester.getEntityTimeToLearn();
        final EntityIteration getEntityIteration = tester.getEntityIteration();
        final Integer getEntityIdIteration = tester.getEntityIdIterationT2M();
        final Integer getEntityIdTeam = tester.getEntityIdTeamT2M();



        // Assert
        assertEquals(id, getId, "setEntityId must be my 42");
        assertEquals(buildAndIntegrationFrequency, getBuildAndIntegrationFrequency, "setEntityBuildAndIntegrationFrequency must be 10 by week");
        assertEquals(releaseFrequency, getReleaseFrequency, "setEntityReleaseFrequency must be Monthly");
        assertEquals(releaseStabilizationPeriod, getReleaseStabilizationPeriod, "setEntityReleaseStabilizationPeriod must be 3 days");
        assertEquals(meanTimeToRepair, getMeanTimeToRepair, "setEntityMeanTimeToRepair must be 3/5");
        assertEquals(leadTime, getLeadTime, "setEntityLeadTime must be 3 months");
        assertEquals(cycleTime, getCycleTime, "setEntityCycleTime must be 1 month");
        assertEquals(timeToLearn, getTimeToLearn, "setEntityTimeToLearn must be 1 month");
        assertEquals(entityIteration, getEntityIteration, "setEntityIteration must be new EntityIteration()");
        assertEquals(idIteration, getEntityIdIteration, "setEntityIdIteration must be my 2");
        assertEquals(idTeam, getEntityIdTeam, "setEntityIdTeam must be my 5");

    }

}
