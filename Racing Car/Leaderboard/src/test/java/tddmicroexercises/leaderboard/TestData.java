package tddmicroexercises.leaderboard;

import org.junit.jupiter.api.BeforeEach;
import tddmicroexercises.leaderboard.interfaces.Competitor;
import tddmicroexercises.leaderboard.models.Driver;
import tddmicroexercises.leaderboard.models.Race;
import tddmicroexercises.leaderboard.models.SelfDrivingCar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {

    public static Competitor competitor1;
    public static Competitor competitor2;
    public static Competitor competitor3;
    public static Competitor competitor4;

    public static Race race1;
    public static Race race2;
    public static Race race3;
    public static Race race4;

    @BeforeEach
    public void setUp() {
        initializeCompetitors();
    }

    public static List<Race> createListOfRaces() {
        List<Race> races = new ArrayList<>();
        initializeCompetitors();
        race1 = new Race(new HashMap<>() {
            {
                put(competitor1, 25);
                put(competitor2, 18);
                put(competitor3, 15);
                put(competitor4, 12);
            }
        });
        race2 = new Race(new HashMap<>() {
            {
                put(competitor1, 25);
                put(competitor3, 18);
                put(competitor2, 15);
                put(competitor4, 12);
            }
        });
        race3 = new Race(new HashMap<>() {
            {
                put(competitor2, 25);
                put(competitor1, 18);
                put(competitor3, 15);
                put(competitor4, 12);
            }
        });
        race4 = new Race(new HashMap<>() {
            {
                put(competitor1, 25);
                put(competitor4, 18);
                put(competitor3, 15);
                put(competitor2, 12);
            }
        });
        races.add(race1);
        races.add(race2);
        races.add(race3);
        races.add(race4);
        return races;
    }

    public static Map<String, Integer> createMapOfResults() {
        Map<String, Integer> results = new HashMap<>(){
            {
                put(competitor1.getDescription(), 70);
                put(competitor2.getDescription(), 54);
                put(competitor3.getDescription(), 93);
                put(competitor4.getDescription(), 63);
            }
        };
        return results;
    }

    private static void initializeCompetitors() {
        competitor1 = new Driver("Nico Rosberg", "DE");
        competitor2 = new Driver("Lewis Hamilton", "UK");
        competitor3 = new SelfDrivingCar("1.2", "Acme");
        competitor4 = new SelfDrivingCar("1.5", "Acme");
    }
}
