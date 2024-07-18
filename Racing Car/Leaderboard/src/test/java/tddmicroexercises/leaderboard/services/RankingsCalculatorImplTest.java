package tddmicroexercises.leaderboard.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import tddmicroexercises.leaderboard.TestData;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RankingsCalculatorImplTest {

    @InjectMocks
    private RankingsCalculatorImpl rankingsCalculator;

    @BeforeEach
    void setUp() {
        rankingsCalculator = new RankingsCalculatorImpl();
    }

    @Test
    void givenMapOfResults_whenCalculateRankingsCalled_thenReturnListOfRankings() {

        // Given
        Map<String, Integer> results = TestData.createMapOfResults();

        // When
        List<String> rankings = rankingsCalculator.calculateRankings(results);

        // Then
        assertEquals(4, rankings.size());
        assertEquals(rankings.get(0), "(1.2 - Acme)");
        assertEquals(rankings.get(1), "(Nico Rosberg - DE)");
        assertEquals(rankings.get(2), "(1.5 - Acme)");
        assertEquals(rankings.get(3), "(Lewis Hamilton - UK)");
    }
}