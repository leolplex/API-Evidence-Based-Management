package com.ebm.persistence.entity;

import com.ebm.domain.KVAAbilityToInnovate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityKVAAbilityToInnovateTest {

    EntityKVAAbilityToInnovate tester;

    @BeforeEach
    void initEach() {
        tester = new EntityKVAAbilityToInnovate();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getEntityId(), "getId must be null");
        assertNull(tester.getEntityFeatureUsageIndex(), "getFeatureUsageIndex must be null");
        assertNull(tester.getEntityInnovationRate(), "getInnovationRate must be null");
        assertNull(tester.getEntityDefectTrends(), "getDefectTrends must be null");
        assertNull(tester.getEntityOnProductIndex(), "getOnProductIndex must be null");
        assertNull(tester.getEntityInstalledVersionIndex(), "getInstalledVersionIndex must be null");
        assertNull(tester.getEntityTechnicalDebt(), "getTechnicalDebt must be null");
        assertNull(tester.getEntityProductionIncidentTrends(), "getProductionIncidentTrends must be null");
        assertNull(tester.getEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(), "getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches must be null");
        assertNull(tester.getEntityTimeSpentContextSwitching(), "getTimeSpentContextSwitching must be null");
        assertNull(tester.getEntityIteration(), "getTimeSpentContextSwitching must be null");
        assertNull(tester.getEntityIdTeamA2I(), "getEntityIdTeamA2I must be null");
        assertNull(tester.getEntityIdIterationA2I(), "getEntityIdIterationA2I must be null");

    }

    @Test
    void getAndSetNewObject() {
        // Arrange
        final Integer id = 42;
        final String featureUsageIndex = "7/10";
        final String innovationRate = "0.33";
        final String defectTrends = "+60";
        final String onProductIndex = "80%";
        final String installedVersionIndex = "2";
        final String technicalDebt = "2 months";
        final String productionIncidentTrends = "3 times by iteration";
        final String activeCodeBranchesTimeSpentMergingCodeBetweenBranches = "5 hours";
        final String timeSpentContextSwitching = "3";
        final EntityIteration entityIteration = new EntityIteration();
        final Integer idIteration = 2;
        final Integer idTeam = 6;


        //Act
        tester.setEntityId(id);
        tester.setEntityFeatureUsageIndex(featureUsageIndex);
        tester.setEntityInnovationRate(innovationRate);
        tester.setEntityDefectTrends(defectTrends);
        tester.setEntityOnProductIndex(onProductIndex);
        tester.setEntityInstalledVersionIndex(installedVersionIndex);
        tester.setEntityTechnicalDebt(technicalDebt);
        tester.setEntityProductionIncidentTrends(productionIncidentTrends);
        tester.setEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(activeCodeBranchesTimeSpentMergingCodeBetweenBranches);
        tester.setEntityTimeSpentContextSwitching(timeSpentContextSwitching);
        tester.setEntityIteration(entityIteration);
        tester.setEntityIdIterationA2I(idIteration);
        tester.setEntityIdTeamA2I(idTeam);



        final Integer getId = tester.getEntityId();
        final String getFeatureUsageIndex = tester.getEntityFeatureUsageIndex();
        final String getInnovationRate = tester.getEntityInnovationRate();
        final String getDefectTrends = tester.getEntityDefectTrends();
        final String getOnProductIndex = tester.getEntityOnProductIndex();
        final String getInstalledVersionIndex = tester.getEntityInstalledVersionIndex();
        final String getTechnicalDebt = tester.getEntityTechnicalDebt();
        final String getProductionIncidentTrends = tester.getEntityProductionIncidentTrends();
        final String getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches = tester.getEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches();
        final String getTimeSpentContextSwitching = tester.getEntityTimeSpentContextSwitching();
        final EntityIteration getEntityIteration = tester.getEntityIteration();
        final Integer getIdIterationA2I = tester.getEntityIdIterationA2I();
        final Integer getIdTeamA2I = tester.getEntityIdTeamA2I();


        // Assert
        assertEquals(id, getId, "setId must be my 42");
        assertEquals(featureUsageIndex, getFeatureUsageIndex, "setEntityFeatureUsageIndex must be 7/10");
        assertEquals(innovationRate, getInnovationRate, "setEntityInnovationRate must be 0.33");
        assertEquals(defectTrends, getDefectTrends, "setEntityDefectTrends must be +60");
        assertEquals(onProductIndex, getOnProductIndex, "setEntityOnProductIndex must be 80%");
        assertEquals(installedVersionIndex, getInstalledVersionIndex, "setEntityInstalledVersionIndex must be 2");
        assertEquals(technicalDebt, getTechnicalDebt, "setEntityTechnicalDebt must be 2 months");
        assertEquals(productionIncidentTrends, getProductionIncidentTrends, "setEntityProductionIncidentTrends must be 3 times by iteration");
        assertEquals(activeCodeBranchesTimeSpentMergingCodeBetweenBranches, getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches, "setEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches must be 3 times by 5 hours");
        assertEquals(timeSpentContextSwitching, getTimeSpentContextSwitching, "setEntityTimeSpentContextSwitching must be 3");
        assertEquals(entityIteration, getEntityIteration, "setEntityIteration must be new EntityIteration()");
        assertEquals(idTeam, getIdTeamA2I, "setEntityIdTeamA2I must be my 2");
        assertEquals(idIteration, getIdIterationA2I, "setEntityIdIterationA2I must be my 6");


    }

}
