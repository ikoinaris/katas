import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.text.Position;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    @Mock
    private Command command;

    @Nested
    class MoveSuccess {

        @Test
        public void givenRoversPosition_WhenMoveForwardCalled_ThenIncreaseY() {

            // Given
            var positionX = 5;
            var positionY = 5;

            // When
            Position newPosition = command.moveForward(positionX, positionY);

            // Then
            assertEquals(newPosition.getX(), 5);
            assertEquals(newPosition.getY(), 6);
        }

        @Test
        public void givenRoversPosition_WhenMoveBackwardsCalled_ThenDecreaseY() {
            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPosition_WhenTurnRightCalled_ThenIncreaseX() {
            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPosition_WhenTurnLeftCalled_ThenDecreaseX() {
            // Given
            // When
            // Then
        }

    }

    @Nested
    class MoveFailure {

        @Test
        public void givenRoversPositionAndLastMoveBackwards_WhenMoveForwardCalled_ThenStayStill() {
            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPositionAndLastMoveForward_WhenMoveBackwardsCalled_ThenStayStill() {
            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPositionAndLastMoveRight_WhenTurnLeftCalled_ThenStayStill() {
            // Given
            // When
            // Then
        }

        @Test
        public void givenRoversPositionAndLastMoveLeft_WhenTurnRightCalled_ThenStayStill() {
            // Given
            // When
            // Then
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
