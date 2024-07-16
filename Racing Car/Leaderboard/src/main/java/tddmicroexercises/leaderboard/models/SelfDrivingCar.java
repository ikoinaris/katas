package tddmicroexercises.leaderboard.models;

import tddmicroexercises.leaderboard.interfaces.Competitor;

public record SelfDrivingCar(String algorithmVersion, String company) implements Competitor {

    @Override
    public String getDescription() {
        return String.format("(%s - %s)", algorithmVersion, company);
    }
}
