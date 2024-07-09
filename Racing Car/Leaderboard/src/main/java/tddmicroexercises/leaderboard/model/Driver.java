package tddmicroexercises.leaderboard.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import tddmicroexercises.leaderboard.interfaces.Competitor;

@AllArgsConstructor
@EqualsAndHashCode
public class Driver implements Competitor {

    @Getter
    private final String name;
    private final String country;
}
