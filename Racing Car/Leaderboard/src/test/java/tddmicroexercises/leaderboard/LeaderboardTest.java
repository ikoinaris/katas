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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderboardTest {

    private RankingsCalculatorImpl rankingsCalculator;

    private ResultsCalculatorImpl resultsCalculator;

    @InjectMocks
    private Leaderboard leaderboard;

    private List<Race> races;

    @BeforeEach
    public void setUp() {
        races = TestData.createListOfRaces();
        leaderboard = new Leaderboard(races.toArray(new Race[races.size()]));
        rankingsCalculator = mock(RankingsCalculatorImpl.class);
        resultsCalculator = mock(ResultsCalculatorImpl.class);
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
}
