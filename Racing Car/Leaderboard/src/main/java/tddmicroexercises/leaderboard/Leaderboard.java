package tddmicroexercises.leaderboard;

import lombok.var;
import tddmicroexercises.leaderboard.interfaces.Competitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    private final List<Race> races;
    static List<Competitor> results;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> competitorResults() {
        Map<String, Integer> results = new HashMap<>();
        for (Race race : races) {
            race.getResults().forEach(competitor -> {
                var competitorName = competitor.getName();
                var points = race.getPoints(competitor);
                results.put(competitorName, results.get(competitorName) + points);
            });
        }
        return results;
    }

    public List<String> competitorRankings() {
        Map<String, Integer> results = competitorResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        Collections.sort(resultsList, new CompetitorByPointsDescendingComparator(results));
        return resultsList;
    }

    private static final class CompetitorByPointsDescendingComparator implements Comparator<String> {

        private final Map<String, Integer> results;

        private CompetitorByPointsDescendingComparator(Map<String, Integer> results) {
            this.results = results;
        }

        @Override
        public int compare(String competitorName1, String competitorName2) {
            return -results.get(competitorName1).compareTo(results.get(competitorName2));
        }
    }

}
