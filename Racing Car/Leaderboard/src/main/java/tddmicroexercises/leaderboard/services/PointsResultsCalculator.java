package tddmicroexercises.leaderboard.services;

import tddmicroexercises.leaderboard.Race;
import tddmicroexercises.leaderboard.interfaces.ResultsCalculator;

import java.util.List;
import java.util.Map;

public class PointsResultsCalculator implements ResultsCalculator {

    @Override
    public Map<String, Integer> calculateResults(List<Race> races) {
        return Map.of();
    }
}
