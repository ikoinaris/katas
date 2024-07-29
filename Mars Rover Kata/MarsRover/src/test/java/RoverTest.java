import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.text.Position;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    @Mock
    private MoveCommand moveCommand;

    @Nested
    class MoveSuccess {

        @Test
        public void givenRoversPosition_WhenMoveForwardCalled_ThenIncreaseY() {
            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("N");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 5);
            assertEquals(expectedPosition.getY(), 6);
        }

        @Test
        public void givenRoversPosition_WhenMoveBackwardsCalled_ThenDecreaseY() {
            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("S");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 5);
            assertEquals(expectedPosition.getY(), 4);
        }

        @Test
        public void givenRoversPosition_WhenTurnRightCalled_ThenIncreaseX() {
            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("E");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 6);
            assertEquals(expectedPosition.getY(), 5);
        }

        @Test
        public void givenRoversPosition_WhenTurnLeftCalled_ThenDecreaseX() {
            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("W");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 4);
            assertEquals(expectedPosition.getY(), 5);
        }

        @Test
        public void givenRoversPosition_WhenSequenceOfCommandsReceived_thenReturnFinalPosition() {
            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("N", "E", "S", "E", "N", "W", "S");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 6);
            assertEquals(expectedPosition.getY(), 5);

        }

    }

    @Nested
    class MoveFailure {

        @Test
        public void givenRoversPositionAndLastMoveBackwards_WhenMoveForwardCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("E", "S", "N", "W");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 6);
            assertEquals(expectedPosition.getY(), 5);
        }

        @Test
        public void givenRoversPositionAndLastMoveForward_WhenMoveBackwardsCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("E", "N", "S", "W");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 6);
            assertEquals(expectedPosition.getY(), 5);
        }

        @Test
        public void givenRoversPositionAndLastMoveRight_WhenTurnLeftCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("N", "E", "W", "S");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 6);
            assertEquals(expectedPosition.getY(), 5);
        }

        @Test
        public void givenRoversPositionAndLastMoveLeft_WhenTurnRightCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<String> commands = List.of("N", "W", "E", "S");

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.getX(), 6);
            assertEquals(expectedPosition.getY(), 5);
        }

    }

    @Nested
    class LastPosition {

        @Test
        public void givenRoversPosition_WhenDetectObstacle_ThenMoveToLastPosition() {

            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPosition_WhenReachAreasWidth_ThenMoveToLastPosition() {

            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPosition_WhenReachAreasHeight_ThenMoveToLastPosition() {

            // Given
            // When
            // Then
        }
    }
}
