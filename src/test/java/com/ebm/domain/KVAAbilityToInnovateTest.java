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
    void getAndSetFeatureUsageIndex() {
        // Arrange
        final String featureUsageIndex = "7/10";

        //Act
        tester.setFeatureUsageIndex(featureUsageIndex);
        final String getFeatureUsageIndex = tester.getFeatureUsageIndex();

        // Assert
        assertEquals(featureUsageIndex, getFeatureUsageIndex, "setFeatureUsageIndex must be 7/10");
    }

    @Test
    void getAndSetInnovationRate() {
        // Arrange
        final String innovationRate = "0.33";

        //Act
        tester.setInnovationRate(innovationRate);
        final String getInnovationRate = tester.getInnovationRate();

        // Assert
        assertEquals(innovationRate, getInnovationRate, "setInnovationRate must be 0.33");
    }

    @Test
    void getAndSetDefectTrends() {
        // Arrange
        final String defectTrends = "+60";

        //Act
        tester.setDefectTrends(defectTrends);
        final String getDefectTrends = tester.getDefectTrends();

        // Assert
        assertEquals(defectTrends, getDefectTrends, "setDefectTrends must be +60");
    }

    @Test
    void getAndSetOnProductIndex() {
        // Arrange
        final String onProductIndex = "80%";

        //Act
        tester.setOnProductIndex(onProductIndex);
        final String getOnProductIndex = tester.getOnProductIndex();

        // Assert
        assertEquals(onProductIndex, getOnProductIndex, "setOnProductIndex must be 80%");
    }

    @Test
    void getAndSetInstalledVersionIndex() {
        // Arrange
        final String installedVersionIndex = "2";

        //Act
        tester.setInstalledVersionIndex(installedVersionIndex);
        final String getInstalledVersionIndex = tester.getInstalledVersionIndex();

        // Assert
        assertEquals(installedVersionIndex, getInstalledVersionIndex, "setInstalledVersionIndex must be 2");
    }

    @Test
    void getAndSetTechnicalDebt() {
        // Arrange
        final String technicalDebt = "2 months";

        //Act
        tester.setTechnicalDebt(technicalDebt);
        final String getTechnicalDebt = tester.getTechnicalDebt();

        // Assert
        assertEquals(technicalDebt, getTechnicalDebt, "setTechnicalDebt must be 2 months");
    }

    @Test
    void getAndSetProductionIncidentTrends() {
        // Arrange
        final String productionIncidentTrends = "3 times by iteration";

        //Act
        tester.setProductionIncidentTrends(productionIncidentTrends);
        final String getProductionIncidentTrends = tester.getProductionIncidentTrends();

        // Assert
        assertEquals(productionIncidentTrends, getProductionIncidentTrends, "setProductionIncidentTrends must be 3 times by iteration");
    }

    @Test
    void getAndSetActiveCodeBranchesTimeSpentMergingCodeBetweenBranches() {
        // Arrange
        final String activeCodeBranchesTimeSpentMergingCodeBetweenBranches = "5 hours";

        //Act
        tester.setActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(activeCodeBranchesTimeSpentMergingCodeBetweenBranches);
        final String getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches = tester.getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches();

        // Assert
        assertEquals(activeCodeBranchesTimeSpentMergingCodeBetweenBranches, getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches, "setActiveCodeBranchesTimeSpentMergingCodeBetweenBranches must be 3 times by 5 hours");
    }

    @Test
    void getAndSetTimeSpentContextSwitching() {
        // Arrange
        final String timeSpentContextSwitching = "3";

        //Act
        tester.setTimeSpentContextSwitching(timeSpentContextSwitching);
        final String getTimeSpentContextSwitching = tester.getTimeSpentContextSwitching();

        // Assert
        assertEquals(timeSpentContextSwitching, getTimeSpentContextSwitching, "setTimeSpentContextSwitching must be 3");
    }
}
