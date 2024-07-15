package tddmicroexercises.leaderboard.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Race {

    @Getter
    private final Map<Driver, Integer> results;
}
