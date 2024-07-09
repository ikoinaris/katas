package tddmicroexercises.leaderboard;

import lombok.Getter;
import tddmicroexercises.leaderboard.interfaces.Competitor;

import java.util.Arrays;
import java.util.List;

public class Race {

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};
    private final String name;
    @Getter
    private final List<Competitor> results;

    public Race(String name, Competitor... results) {
        this.name = name;
        this.results = Arrays.asList(results);
    }

    public int getPosition(Competitor competitor) {
        return this.results.indexOf(competitor);
    }

    public int getPoints(Competitor competitor) {
        int position = getPosition(competitor);
        return position >= 0 && position < POINTS.length ? POINTS[position] : 0;
    }
}
