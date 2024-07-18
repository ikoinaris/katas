package tddmicroexercises.leaderboard;

import lombok.AllArgsConstructor;
import tddmicroexercises.leaderboard.models.Race;
import tddmicroexercises.leaderboard.services.RankingsCalculatorImpl;
import tddmicroexercises.leaderboard.services.ResultsCalculatorImpl;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class Leaderboard {

    private RankingsCalculatorImpl rankingsCalculator;
    private ResultsCalculatorImpl resultsCalculator;
    private List<Race> races;

    public Map<String, Integer> driverResults() { return resultsCalculator.calculateResults(races); }

    public List<String> driverRankings() { return rankingsCalculator.calculateRankings(driverResults()); }

}
