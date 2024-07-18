package tddmicroexercises.leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tddmicroexercises.leaderboard.models.Race;
import tddmicroexercises.leaderboard.services.RankingsCalculatorImpl;
import tddmicroexercises.leaderboard.services.ResultsCalculatorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderboardTest {

    @Mock
    private RankingsCalculatorImpl rankingsCalculator;

    @Mock
    private ResultsCalculatorImpl resultsCalculator;

    @InjectMocks
    private Leaderboard leaderboard;

    private List<Race> races;

    @BeforeEach
    public void setUp() {
        races = TestData.createListOfRaces();
        leaderboard = new Leaderboard(rankingsCalculator, resultsCalculator, races);
    }

    @Test
    public void givenListOfRaces_whenDriverResultsCalled_thenReturnMapOfResults() {
        //Given
        Map<String, Integer> expectedResults = new HashMap<>(){
            {
                put(TestData.competitor1.getDescription(), 75);
                put(TestData.competitor2.getDescription(), 50);
            }
        };
        when(resultsCalculator.calculateResults(races)).thenReturn(expectedResults);
        //When
        Map<String, Integer> results = leaderboard.driverResults();
        //Then
        verify(resultsCalculator).calculateResults(races);
    }

    @Test
    public void givenMapOfResults_whenDriverRankingsCalled_thenReturnListOfDriverNames() {
        Map<String, Integer> mockResults = new HashMap<>(){
            {
                put(TestData.competitor2.getDescription(), 50);
                put(TestData.competitor1.getDescription(), 75);
            }
        };
        List<String> expectedRankings =
                List.of(TestData.competitor1.getDescription(), TestData.competitor2.getDescription());
        when(rankingsCalculator.calculateRankings(mockResults)).thenReturn(expectedRankings);

        // When
        List<String> results = leaderboard.driverRankings();

        // Then
        verify(rankingsCalculator).calculateRankings(mockResults);
        assertEquals(2, results.size());
        assertEquals("Nico Rosberg - DE", results.get(0));
        assertEquals("Lewis Hamilton - UK", results.get(1));
    }
}
