package tddmicroexercises.leaderboard.services;

import tddmicroexercises.leaderboard.interfaces.RankingsCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RankingsCalculatorImpl implements RankingsCalculator {

    @Override
    public List<String> calculateRankings(Map<String, Integer> results) {
        List<String> driverRankings = new ArrayList<>(results.keySet());
        driverRankings.sort((driver1, driver2) -> results.get(driver2).compareTo(results.get(driver1)));
        return driverRankings;
    }
}
