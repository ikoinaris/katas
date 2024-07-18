package tddmicroexercises.leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tddmicroexercises.leaderboard.models.Race;
import tddmicroexercises.leaderboard.services.RankingsCalculatorImpl;
import tddmicroexercises.leaderboard.services.ResultsCalculatorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeaderboardTest {

    @Mock
    private RankingsCalculatorImpl rankingsCalculator;

    @Mock
    private ResultsCalculatorImpl resultsCalculator;

    @InjectMocks
    private Leaderboard leaderboard;

    @Mock
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
        // When
        List<String> results = leaderboard.driverRankings();
        // Then
        verify(rankingsCalculator).calculateRankings(new HashMap<>());
    }
}
