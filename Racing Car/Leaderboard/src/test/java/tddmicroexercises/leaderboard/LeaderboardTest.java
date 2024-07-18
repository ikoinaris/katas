package tddmicroexercises.leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tddmicroexercises.leaderboard.models.Race;
import tddmicroexercises.leaderboard.services.RankingsCalculatorImpl;
import tddmicroexercises.leaderboard.services.ResultsCalculatorImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderboardTest {

    @InjectMocks
    private Leaderboard leaderboard;

    @Mock
    private ResultsCalculatorImpl resultsCalculator;

    @Mock
    private RankingsCalculatorImpl rankingsCalculator;

    @Mock
    private List<Race> mockRaces;
    private Map<String, Integer> mockResults;

    @BeforeEach
    public void setUp() {
        leaderboard = new Leaderboard();
        resultsCalculator = new ResultsCalculatorImpl();
        rankingsCalculator = new RankingsCalculatorImpl();
        mockRaces = TestData.createListOfRaces();
        mockResults = TestData.createMapOfResults();
    }

    @Test
    public void givenListOfRaces_whenDriverResultsCalled_thenReturnSumOfDriversPoints() {
        // Given
        when(resultsCalculator.calculateResults(anyList())).thenReturn(mockResults);
        // When
        Map<String, Integer> results = leaderboard.driverResults();
        // Then
        verify(resultsCalculator).calculateResults(mockRaces);
        assertEquals(4, results.size());
        assertEquals(70, results.get("(Nico Rosberg - DE)"));
        assertEquals(54, results.get("(Lewis Hamilton - UK)"));
        assertEquals(93, results.get("(1.2 - Acme)"));
        assertEquals(63, results.get("(1.5 - Acme)"));
    }

    @Test
    public void givenDriverResultsWithUnevenPoints_whenDriverRankingsCalled_thenReturnResultsList() {
        // Given
        List<String> mockRankings = Arrays.asList("(Nico Rosberg - DE)", "(Lewis Hamilton - UK)", "(1.2 - Acme)", "(1.5 - Acme)");
        when(resultsCalculator.calculateResults(TestData.createListOfRaces())).thenReturn(mockResults);
        when(rankingsCalculator.calculateRankings(mockResults)).thenReturn(mockRankings);
        // When
        List<String> rankings = leaderboard.driverRankings();
        // Then
        verify(rankingsCalculator).calculateRankings(mockResults);
        assertEquals(4, rankings.size());
        assertEquals("(Nico Rosberg - DE)", rankings.get(0));
        assertEquals("(Lewis Hamilton - UK)", rankings.get(1));
        assertEquals("(1.2 - Acme)", rankings.get(0));
        assertEquals("(1.5 - Acme)", rankings.get(1));
    }
}
