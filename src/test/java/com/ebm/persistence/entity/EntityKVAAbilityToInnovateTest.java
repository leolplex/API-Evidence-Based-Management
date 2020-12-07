package com.ebm.persistence.entity;

import com.ebm.domain.KVAAbilityToInnovate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EntityKVAAbilityToInnovateTest {

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
    }

    @Test
    void getAndSetEntityId() {
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityId(id);
        final Integer getId = tester.getEntityId();

        // Assert
        assertEquals(id, getId, "setId must be my 42");
    }

    @Test
    void getAndSetEntityFeatureUsageIndex() {
        // Arrange
        final String featureUsageIndex = "7/10";

        //Act
        tester.setEntityFeatureUsageIndex(featureUsageIndex);
        final String getFeatureUsageIndex = tester.getEntityFeatureUsageIndex();

        // Assert
        assertEquals(featureUsageIndex, getFeatureUsageIndex, "setEntityFeatureUsageIndex must be 7/10");
    }

    @Test
    void getAndSetEntityInnovationRate() {
        // Arrange
        final String innovationRate = "0.33";

        //Act
        tester.setEntityInnovationRate(innovationRate);
        final String getInnovationRate = tester.getEntityInnovationRate();

        // Assert
        assertEquals(innovationRate, getInnovationRate, "setEntityInnovationRate must be 0.33");
    }

    @Test
    void getAndSetEntityDefectTrends() {
        // Arrange
        final String defectTrends = "+60";

        //Act
        tester.setEntityDefectTrends(defectTrends);
        final String getDefectTrends = tester.getEntityDefectTrends();

        // Assert
        assertEquals(defectTrends, getDefectTrends, "setEntityDefectTrends must be +60");
    }

    @Test
    void getAndSetEntityOnProductIndex() {
        // Arrange
        final String onProductIndex = "80%";

        //Act
        tester.setEntityOnProductIndex(onProductIndex);
        final String getOnProductIndex = tester.getEntityOnProductIndex();

        // Assert
        assertEquals(onProductIndex, getOnProductIndex, "setEntityOnProductIndex must be 80%");
    }

    @Test
    void getAndSetEntityInstalledVersionIndex() {
        // Arrange
        final String installedVersionIndex = "2";

        //Act
        tester.setEntityInstalledVersionIndex(installedVersionIndex);
        final String getInstalledVersionIndex = tester.getEntityInstalledVersionIndex();

        // Assert
        assertEquals(installedVersionIndex, getInstalledVersionIndex, "setEntityInstalledVersionIndex must be 2");
    }

    @Test
    void getAndSetEntityTechnicalDebt() {
        // Arrange
        final String technicalDebt = "2 months";

        //Act
        tester.setEntityTechnicalDebt(technicalDebt);
        final String getTechnicalDebt = tester.getEntityTechnicalDebt();

        // Assert
        assertEquals(technicalDebt, getTechnicalDebt, "setEntityTechnicalDebt must be 2 months");
    }

    @Test
    void getAndSetEntityProductionIncidentTrends() {
        // Arrange
        final String productionIncidentTrends = "3 times by iteration";

        //Act
        tester.setEntityProductionIncidentTrends(productionIncidentTrends);
        final String getProductionIncidentTrends = tester.getEntityProductionIncidentTrends();

        // Assert
        assertEquals(productionIncidentTrends, getProductionIncidentTrends, "setEntityProductionIncidentTrends must be 3 times by iteration");
    }

    @Test
    void getAndSetEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches() {
        // Arrange
        final String activeCodeBranchesTimeSpentMergingCodeBetweenBranches = "5 hours";

        //Act
        tester.setEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(activeCodeBranchesTimeSpentMergingCodeBetweenBranches);
        final String getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches = tester.getEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches();

        // Assert
        assertEquals(activeCodeBranchesTimeSpentMergingCodeBetweenBranches, getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches, "setEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches must be 3 times by 5 hours");
    }

    @Test
    void getAndSetEntityTimeSpentContextSwitching() {
        // Arrange
        final String timeSpentContextSwitching = "3";

        //Act
        tester.setEntityTimeSpentContextSwitching(timeSpentContextSwitching);
        final String getTimeSpentContextSwitching = tester.getEntityTimeSpentContextSwitching();

        // Assert
        assertEquals(timeSpentContextSwitching, getTimeSpentContextSwitching, "setEntityTimeSpentContextSwitching must be 3");
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
