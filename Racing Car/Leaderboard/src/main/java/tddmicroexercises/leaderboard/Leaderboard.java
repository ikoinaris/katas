package tddmicroexercises.leaderboard;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import tddmicroexercises.leaderboard.models.Race;
import tddmicroexercises.leaderboard.services.RankingsCalculatorImpl;
import tddmicroexercises.leaderboard.services.ResultsCalculatorImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class Leaderboard {

    private RankingsCalculatorImpl rankingsCalculator;
    private ResultsCalculatorImpl resultsCalculator;
    private List<Race> races;

    private Map<String, Integer> results;
    public Leaderboard() {
        results = driverResults();
    }

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        return resultsCalculator.calculateResults(races);
    }

    public List<String> driverRankings() {
        return rankingsCalculator.calculateRankings(results);
    }

}
