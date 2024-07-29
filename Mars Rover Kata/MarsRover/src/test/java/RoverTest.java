import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RoverTest {

    @Nested
    class MoveSuccess {

        @Test
        public void givenRoversPosition_WhenMoveForwardCalled_ThenIncreaseY() {
            // Given
            // When
            // Then
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
