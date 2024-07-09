package tddmicroexercises.leaderboard;


import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tddmicroexercises.leaderboard.interfaces.Competitor;

public class RaceTest {

    @InjectMocks
    private Race race;

    @Mock
    private Competitor competitor;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void givenValidCompetitor_whenGetPointCalled_thenReturnCompetitorPoints() {
        // Given

        // When
        var result = race.getPoints(competitor);

        // Then
    }

}
