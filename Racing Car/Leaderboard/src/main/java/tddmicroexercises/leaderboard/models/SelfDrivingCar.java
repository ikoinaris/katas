package tddmicroexercises.leaderboard.models;

import tddmicroexercises.leaderboard.interfaces.Competitor;

public class SelfDrivingCar implements Competitor {

    private String algorithmVersion;
    private String company;

    public SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    public String getDescription() {
        return String.format("(%s - %s)", algorithmVersion, company);
    }
}
