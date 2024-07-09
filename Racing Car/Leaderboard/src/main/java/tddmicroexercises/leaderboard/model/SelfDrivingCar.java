package tddmicroexercises.leaderboard.model;

import lombok.Getter;
import lombok.Setter;
import tddmicroexercises.leaderboard.interfaces.Competitor;

@Getter
public class SelfDrivingCar implements Competitor {

    @Setter
    private String algorithmVersion;
    private final String company;

    public SelfDrivingCar(String algorithmVersion, String company) {
        this.algorithmVersion = algorithmVersion;
        this.company = company;
    }

    @Override
    public String getName() {
        return String.format("Self driving car - %s (%s) ", company, algorithmVersion);
    }


}
