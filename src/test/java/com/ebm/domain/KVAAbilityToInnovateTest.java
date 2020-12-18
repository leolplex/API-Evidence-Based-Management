package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KVAAbilityToInnovateTest {

    KVAAbilityToInnovate tester;

    @BeforeEach
    void initEach() {
        tester = new KVAAbilityToInnovate();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getId(), "getId must be null");
        assertNull(tester.getFeatureUsageIndex(), "getFeatureUsageIndex must be null");
        assertNull(tester.getInnovationRate(), "getInnovationRate must be null");
        assertNull(tester.getDefectTrends(), "getDefectTrends must be null");
        assertNull(tester.getOnProductIndex(), "getOnProductIndex must be null");
        assertNull(tester.getInstalledVersionIndex(), "getInstalledVersionIndex must be null");
        assertNull(tester.getTechnicalDebt(), "getTechnicalDebt must be null");
        assertNull(tester.getProductionIncidentTrends(), "getProductionIncidentTrends must be null");
        assertNull(tester.getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(), "getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches must be null");
        assertNull(tester.getTimeSpentContextSwitching(), "getTimeSpentContextSwitching must be null");
        assertNull(tester.getIdTeam(), "getIdTeam must be null");
        assertNull(tester.getIdIteration(), "getIdIteration must be null");

    }


    @Test
    void getAndSetDefectTrends() {
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
        final Integer idTeam = 2;
        final Integer idIteration = 6;



        //Act
        tester.setInnovationRate(innovationRate);
        tester.setDefectTrends(defectTrends);
        tester.setOnProductIndex(onProductIndex);
        tester.setInstalledVersionIndex(installedVersionIndex);
        tester.setTechnicalDebt(technicalDebt);
        tester.setProductionIncidentTrends(productionIncidentTrends);
        tester.setActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(activeCodeBranchesTimeSpentMergingCodeBetweenBranches);
        tester.setTimeSpentContextSwitching(timeSpentContextSwitching);
        tester.setFeatureUsageIndex(featureUsageIndex);
        tester.setId(id);
        tester.setIdIteration(idIteration);
        tester.setIdTeam(idTeam);

        final Integer getId = tester.getId();
        final String getInnovationRate = tester.getInnovationRate();
        final String getOnProductIndex = tester.getOnProductIndex();
        final String getDefectTrends = tester.getDefectTrends();
        final String getInstalledVersionIndex = tester.getInstalledVersionIndex();
        final String getTechnicalDebt = tester.getTechnicalDebt();
        final String getProductionIncidentTrends = tester.getProductionIncidentTrends();
        final String getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches = tester.getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches();
        final String getTimeSpentContextSwitching = tester.getTimeSpentContextSwitching();
        final String getFeatureUsageIndex = tester.getFeatureUsageIndex();
        final Integer getIdTeam = tester.getIdTeam();
        final Integer getIdIteration = tester.getIdIteration();


        // Assert
        assertEquals(id, getId, "setId must be my 42");
        assertEquals(innovationRate, getInnovationRate, "setInnovationRate must be 0.33");
        assertEquals(defectTrends, getDefectTrends, "setDefectTrends must be +60");
        assertEquals(onProductIndex, getOnProductIndex, "setOnProductIndex must be 80%");
        assertEquals(installedVersionIndex, getInstalledVersionIndex, "setInstalledVersionIndex must be 2");
        assertEquals(technicalDebt, getTechnicalDebt, "setTechnicalDebt must be 2 months");
        assertEquals(productionIncidentTrends, getProductionIncidentTrends, "setProductionIncidentTrends must be 3 times by iteration");
        assertEquals(activeCodeBranchesTimeSpentMergingCodeBetweenBranches, getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches, "setActiveCodeBranchesTimeSpentMergingCodeBetweenBranches must be 3 times by 5 hours");
        assertEquals(timeSpentContextSwitching, getTimeSpentContextSwitching, "setTimeSpentContextSwitching must be 3");
        assertEquals(featureUsageIndex, getFeatureUsageIndex, "setFeatureUsageIndex must be 7/10");
        assertEquals(idTeam, getIdTeam, "setIdTeam must be my 2");
        assertEquals(idIteration, getIdIteration, "setIdIteration must be my 6");


    }
}
