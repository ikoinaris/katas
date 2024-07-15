package tddmicroexercises.leaderboard.interfaces;

import java.util.List;
import java.util.Map;

public interface RankingsCalculator {

    List<String> calculateRankings(Map<String, Integer> results);
}
