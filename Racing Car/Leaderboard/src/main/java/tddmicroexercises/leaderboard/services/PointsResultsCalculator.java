package tddmicroexercises.leaderboard.services;

import tddmicroexercises.leaderboard.models.Driver;
import tddmicroexercises.leaderboard.interfaces.ResultsCalculator;
import tddmicroexercises.leaderboard.models.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsResultsCalculator implements ResultsCalculator {

    @Override
    public Map<String, Integer> calculateResults(List<Race> races) {
        Map<String, Integer> results = new HashMap<>();
        for (Race race : races) {
            for (Map.Entry<Driver, Integer> entry : race.getResults().entrySet()) {
                String driverName = entry.getKey().getName();
                int points = entry.getValue();
                results.merge(driverName, points, Integer::sum);
            }
        }
        return results;
    }
}