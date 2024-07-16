package tddmicroexercises.leaderboard.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tddmicroexercises.leaderboard.interfaces.Competitor;

@RequiredArgsConstructor
public class Driver implements Competitor {

    @Getter
    private final String name;
    private final String country;

    @Override
    public String getDescription() {
        return String.format("(%s - %s)", name, country);
    }
}
