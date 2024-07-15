package tddmicroexercises.leaderboard.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Driver {

    @Getter
    private final String name;
    private final String country;
}
