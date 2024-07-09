package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tddmicroexercises.leaderboard.TestData.driver1;
import static tddmicroexercises.leaderboard.TestData.driver2;
import static tddmicroexercises.leaderboard.TestData.driver3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tddmicroexercises.leaderboard.interfaces.Competitor;

public class LeaderboardTest {

    @Mock
    private Competitor competitor;

    @InjectMocks
    private Leaderboard leaderboard;

    @BeforeEach
    public void setUp() {
        leaderboard = new Leaderboard(createTestRaces());
    }

    @Test
    void givenResultsMap_whenCallCompetitorRankings_thenReturnResultList() {

    }

    @Test
    void givenRaceList_whenCallCompetitorResults_thenReturnResultsMap() {

    }

    private Race[] createTestRaces() {
        Competitor[] competitors = new Competitor[] {};
        var race1 = new Race("Australian Grand Prix", competitors);
        var race2 = new Race("Monaco Grand Prix", competitors);
        var race3 = new Race("Dubai Grand Prix", competitors);
        return new Race[] {race1, race2, race3};
    }


    @Test
    public void itShouldSumThePoints() {
        // setup

        // act
        Map<String, Integer> results = TestData.sampleLeaderboard1.competitorResults();

        // verify
        assertTrue(results.containsKey("Lewis Hamilton"), "results " + results);
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    public void isShouldFindTheWinner() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard1.competitorRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", (Competitor) List.of(driver1, driver2, driver3));
        Race winDriver2 = new Race("Malaysian Grand Prix", (Competitor) List.of(driver2, driver1, driver3));
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.competitorRankings();

        // verify
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
    }

}
