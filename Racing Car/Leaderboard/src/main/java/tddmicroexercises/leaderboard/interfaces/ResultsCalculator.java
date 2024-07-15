package tddmicroexercises.leaderboard.interfaces;

import tddmicroexercises.leaderboard.models.Race;

import java.util.List;
import java.util.Map;

public interface ResultsCalculator {

    Map<String, Integer> calculateResults(List<Race> races);
}
