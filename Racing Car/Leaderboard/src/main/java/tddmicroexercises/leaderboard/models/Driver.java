package tddmicroexercises.leaderboard.models;

import tddmicroexercises.leaderboard.interfaces.Competitor;

public record Driver(String name, String country) implements Competitor {

    @Override
    public String getDescription() {
        return String.format("(%s - %s)", name, country);
    }
}
