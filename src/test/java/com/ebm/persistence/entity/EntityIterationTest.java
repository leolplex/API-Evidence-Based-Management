package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityIterationTest {
    EntityIteration tester;

    @BeforeEach
    void initEach() {
        // Arrange
        tester = new EntityIteration();
    }


    @Test
    void InstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getEntityId(),"getEntityId must be null");
        assertNull(tester.getEntityGoal(),"getEntityGoal must be null");
        assertNull(tester.getEntityStartDate(),"getEntityStartDate must be null");
        assertNull(tester.getEntityEndDate(),"getEntityEndDate must be null");
        assertNull(tester.getEntityState(),"getEntityState must be null");
        assertNull(tester.getEntityKVAUnrealizedValue(),"getEntityKVAUnrealizedValue must be null");
        assertNull(tester.getEntityKVACurrentValue(),"getEntityKVACurrentValue must be null");
        assertNull(tester.getEntityKVAAbilityToInnovate(),"getEntityKVAAbilityToInnovate must be null");
        assertNull(tester.getEntityKVATimeToMarket(),"getEntityKVATimeToMarket must be null");
    }

    @Test
    void  getAndSetEntityId(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityId(id);
        final Integer getEntityId = tester.getEntityId();

        // Assert
        assertEquals(id, getEntityId, "setEntityId must be my 42");
    }

    @Test
    void  getAndSetEntityName(){
        // Arrange
        final String name = "Iteration 1";

        //Act
        tester.setEntityName(name);
        final String getEntityName = tester.getEntityName();

        // Assert
        assertEquals(name, getEntityName, "setEntityName must be my Iteration 1");
    }

    @Test
    void  getAndSetEntityGoal(){
        // Arrange
        final String goal = "Set up deployment pipeline & release an empty site to production";

        //Act
        tester.setEntityGoal(goal);
        final String getEntityGoal = tester.getEntityGoal();

        // Assert
        assertEquals(goal, getEntityGoal, "setEntityGoal must be my Set up deployment pipeline & release an empty site to production");
    }

    @Test
    void  getAndSetEntityStarDate(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.now();

        //Act
        tester.setEntityStartDate(startDate);
        final LocalDateTime getEntityStartDate = tester.getEntityStartDate();

        // Assert
        assertEquals(startDate, getEntityStartDate, "setEntityStartDate must be .now()");
    }

    @Test
    void  getAndSetEntityEndDate(){
        // Arrange
        final LocalDateTime endDate = LocalDateTime.now();

        //Act
        tester.setEntityEndDate(endDate);
        final LocalDateTime getEntityEndDate = tester.getEntityEndDate();

        // Assert
        assertEquals(endDate, getEntityEndDate, "setEntityEndDate must be .now()");
    }

    @ParameterizedTest
    @ValueSource(strings = {"In_Progress", "Completed", "Fail"})
    void  getAndSetEntityStates(String state){

        //Act
        tester.setEntityState(state);
        final String getEntityState = tester.getEntityState();

        // Assert
        assertEquals(state, getEntityState, "setEntityState must be In_Progress | Completed | Fail");
    }


    @Test
    void  getAndSetEntityKVAUnrealizedValue(){
        // Arrange
        final EntityKVAUnrealizedValue entityKVAUnrealizedValue = new EntityKVAUnrealizedValue();

        //Act
        tester.setEntityKVAUnrealizedValue(entityKVAUnrealizedValue);
        final EntityKVAUnrealizedValue getEntityKVAUnrealizedValue = tester.getEntityKVAUnrealizedValue();

        // Assert
        assertEquals(entityKVAUnrealizedValue, getEntityKVAUnrealizedValue, "setEntityKVAUnrealizedValue must be new EntityKVAUnrealizedValue()");
    }

    @Test
    void  getAndSetEntityKVACurrentValue(){
        // Arrange
        final EntityKVACurrentValue entityKVACurrentValue = new EntityKVACurrentValue();

        //Act
        tester.setEntityKVACurrentValue(entityKVACurrentValue);
        final EntityKVACurrentValue getEntityKVACurrentValue = tester.getEntityKVACurrentValue();

        // Assert
        assertEquals(entityKVACurrentValue, getEntityKVACurrentValue, "setEntityKVACurrentValue must be new EntityKVACurrentValue()");
    }

    @Test
    void  getAndSetEntityKVAAbilityToInnovate(){
        // Arrange
        final EntityKVAAbilityToInnovate entityKVAAbilityToInnovate = new EntityKVAAbilityToInnovate();

        //Act
        tester.setEntityKVAAbilityToInnovate(entityKVAAbilityToInnovate);
        final EntityKVAAbilityToInnovate getEntityKVAAbilityToInnovate = tester.getEntityKVAAbilityToInnovate();

        // Assert
        assertEquals(entityKVAAbilityToInnovate, getEntityKVAAbilityToInnovate, "setEntityKVAAbilityToInnovate must be new EntityKVAAbilityToInnovate()");
    }

    @Test
    void  getAndSetEntityKVATimeToMarket(){
        // Arrange
        final EntityKVATimeToMarket entityKVATimeToMarket = new EntityKVATimeToMarket();

        //Act
        tester.setEntityKVATimeToMarket(entityKVATimeToMarket);
        final EntityKVATimeToMarket getEntityKVATimeToMarket = tester.getEntityKVATimeToMarket();

        // Assert
        assertEquals(entityKVATimeToMarket, getEntityKVATimeToMarket, "setEntityKVATimeToMarket must be new EntityKVATimeToMarket()");
    }
}
