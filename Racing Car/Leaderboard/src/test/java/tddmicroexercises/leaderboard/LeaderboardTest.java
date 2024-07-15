package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import tddmicroexercises.leaderboard.models.SelfDrivingCar;

public class LeaderboardTest {

    @InjectMocks
    private Leaderboard leaderboard;

    private Driver[] drivers;

    @BeforeEach
    public void setUp() {
        drivers = createDrivers();
    }

    @Test
    public void givenListOfRaces_whenDriverResultsCalled_thenReturnSumOfDriversPoints() {
        // Given
        leaderboard = new Leaderboard(createRaces());
        // When
        Map<String, Integer> driverResults = leaderboard.driverResults();
        // Then
        assertEquals(5, driverResults.size());
        assertEquals(100, driverResults.get("Nico Rosberg"));
        assertEquals(55, driverResults.get("Self Driving Car - Acme (1.2)"));
        assertEquals(51, driverResults.get("Lewis Hamilton"));
        assertEquals(48, driverResults.get("Sebastian Vettel"));
        assertEquals(38, driverResults.get("Self Driving Car - Acme (1.5)"));
    }

    @Test
    public void givenDriverResultsWithUnevenPoints_whenDriverRankingsCalled_thenReturnResultsList() {
        // Given
        leaderboard = new Leaderboard(createRaces());
        // When
        List<String> driverRankings = leaderboard.driverRankings();
        // Then
        assertEquals(driverRankings.size(), 5);
        assertEquals("Nico Rosberg", driverRankings.get(0));
        assertEquals("Self Driving Car - Acme (1.2)", driverRankings.get(1));
        assertEquals("Lewis Hamilton", driverRankings.get(2));
        assertEquals("Sebastian Vettel", driverRankings.get(3));
        assertEquals("Self Driving Car - Acme (1.5)", driverRankings.get(4));
    }

    @Test
    public void givenDriverResultsWithEvenPoints_whenDriverRankingsCalled_thenReturnResultsList() {
        // Given
        Race race1 = new Race("Australian Grand Prix", drivers[0], drivers[1], drivers[2], drivers[3]);
        Race race2 = new Race("Malaysian Grand Prix", drivers[1], drivers[0], drivers[2], drivers[3]);
        leaderboard = new Leaderboard(race1, race2);

        // When
        List<String> driverRankings = leaderboard.driverRankings();

        // Then
        assertEquals(4, driverRankings.size());
        assertEquals(Arrays.asList(
                drivers[0].getName(), drivers[1].getName(), drivers[2].getName(), drivers[3].getName()), driverRankings);
    }

    private Race[] createRaces() {
        Race[] races = new Race[]{
                new Race("Australian Grand Prix", drivers[0], drivers[1], drivers[2], drivers[3], drivers[4]),
                new Race("Malaysian Grand Prix", drivers[0], drivers[2], drivers[3], drivers[1], drivers[4]),
                new Race("Chinese Grand Prix", drivers[0], drivers[4], drivers[3], drivers[2], drivers[1]),
                new Race("Monaco Grand Prix", drivers[0], drivers[1], drivers[3], drivers[4], drivers[2])
        };
        return races;
    }

    private Driver[] createDrivers() {
        Driver[] drivers = new Driver[]{
                new Driver("Nico Rosberg", "DE"),
                new Driver("Lewis Hamilton", "UK"),
                new Driver("Sebastian Vettel", "DE"),
                new SelfDrivingCar("1.2", "Acme"),
                new SelfDrivingCar("1.5", "Acme")
        };
        return drivers;
    }

}
