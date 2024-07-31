package model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @InjectMocks
    private MarsRover marsRover;

    @Test
    void givenCharArrayOfCommands_whenMoveCommandsCalled_thenPositionAndDirectionUpdated() {

        //Given
        marsRover = new MarsRover(1,2, 'N', new int[][]{}, 20, 20);
        var commands = new char[]{'F', 'L', 'F', 'R', 'F', 'L', 'B'};

        // When
        marsRover.moveCommands(commands);

        // Then
        assertEquals(marsRover.getDirection(), 'W');
        assertEquals(marsRover.getPositionX(), 1);
        assertEquals(marsRover.getPositionY(), 2);
    }

    @Test
    void givenCharArrayOfCommands_WhenObstacleDetected_thenMoveToPreviousPosition() {

        //Given
        marsRover = new MarsRover(5,5, 'N', new int[][]{{5, 6}}, 20, 20);
        var commands = new char[]{'F', 'L', 'F', 'R', 'F', 'L', 'B'};

        // When
        marsRover.moveCommands(commands);

        // Then
        assertEquals(0, marsRover.getPositionX());
        assertEquals(0, marsRover.getPositionY());

    }

    @Test
    void givenCharArrayOfCommands_whenAreasEdgesReached_thenDirectionChanged() {

        //Given
        marsRover = new MarsRover(1,4, 'N', new int[][]{}, 5, 5);
        var commands = new char[]{'F', 'L', 'F', 'R', 'F', 'L', 'B'};

        // When
        marsRover.moveCommands(commands);

        // Then
        assertEquals(marsRover.getDirection(), 'W');
        assertEquals(1, marsRover.getPositionX());
        assertEquals(0, marsRover.getPositionY());
    }
}