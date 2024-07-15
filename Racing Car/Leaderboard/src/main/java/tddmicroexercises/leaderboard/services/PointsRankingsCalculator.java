package tddmicroexercises.leaderboard.services;

import tddmicroexercises.leaderboard.interfaces.RankingsCalculator;

import java.util.List;
import java.util.Map;

public class PointsRankingsCalculator implements RankingsCalculator {
    @Override
    public List<String> calculateRankings(Map<String, Integer> results) {
        return List.of();
    }
}
