package tddmicroexercises.leaderboard.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import tddmicroexercises.leaderboard.TestData;
import tddmicroexercises.leaderboard.models.Race;

import java.util.List;
import java.util.Map;

class ResultsCalculatorImplTest {

    @InjectMocks
    private ResultsCalculatorImpl resultsCalculator;

    @BeforeEach
    void setUp() {
        resultsCalculator = new ResultsCalculatorImpl();
    }

    @Test
    void givenListOfRaces_whenCalculateResultsCalled_thenReturnResultsMap() {
        // Given
        List<Race> races = TestData.createListOfRaces();
        // When
        Map<String, Integer> resultsMap = resultsCalculator.calculateResults(races);
        // Then
        Assertions.assertEquals(4, resultsMap.size());
        Assertions.assertEquals(93, resultsMap.get("(Nico Rosberg - DE)"));
        Assertions.assertEquals(70, resultsMap.get("(Lewis Hamilton - UK)"));
        Assertions.assertEquals(63, resultsMap.get("(1.2 - Acme)"));
        Assertions.assertEquals(54, resultsMap.get("(1.5 - Acme)"));
    }
}