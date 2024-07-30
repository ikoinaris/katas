package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @InjectMocks
    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        marsRover = new MarsRover(1,2, 'N');
    }

    @Test
    void moveCommands() {
        var commands = new char[]{'F', 'L', 'F', 'R', 'F', 'L', 'B'};
        marsRover.moveCommands(commands);

        assertEquals(marsRover.getDirection(), 'W');
        assertEquals(marsRover.getPositionX(), 1);
        assertEquals(marsRover.getPositionY(), 4);
    }
}