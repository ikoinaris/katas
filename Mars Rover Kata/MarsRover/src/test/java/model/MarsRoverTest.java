package model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @InjectMocks
    private MarsRover marsRover;

    @Test
    void givenCharArrayOfCommands_whenMoveForwardCalled_thenPositionUpdated() {

        //Given
        marsRover = new MarsRover(1,1, 'N');

        // When
        marsRover.moveForward();

        // Then
        assertEquals(1, marsRover.getPositionX());
        assertEquals(2, marsRover.getPositionY());
    }

    @Test
    void givenCharArrayOfCommands_whenMoveBackwardCalled_thenPositionUpdated() {

        //Given
        marsRover = new MarsRover(1,2, 'N');

        // When
        marsRover.moveBackwards();

        // Then
        assertEquals(1, marsRover.getPositionX());
        assertEquals(1, marsRover.getPositionY());
    }

    @Test
    void givenCharArrayOfCommands_whenMovingAndTurning_thenPositionAndDirectionUpdated() {

        //Given
        marsRover = new MarsRover(1,1, 'N');

        // When
        marsRover.moveForward();
        marsRover.turnLeft();
        marsRover.moveForward();
        marsRover.turnRight();
        marsRover.moveForward();

        // Then
        assertEquals('N', marsRover.getDirection());
        assertEquals(0, marsRover.getPositionX());
        assertEquals(3, marsRover.getPositionY());
    }
}