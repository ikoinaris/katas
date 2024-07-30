import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoverTest {

    @InjectMocks
    private MoveCommandsImpl moveCommand;

    @Nested
    class MoveSuccess {

        @Test
        public void givenRoversPosition_WhenMoveForwardCalled_ThenIncreaseY() {
            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.NORTH);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 5);
            assertEquals(expectedPosition.positionY(), 6);
        }

        @Test
        public void givenRoversPosition_WhenMoveBackwardsCalled_ThenDecreaseY() {
            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.SOUTH);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 5);
            assertEquals(expectedPosition.positionY(), 4);
        }

        @Test
        public void givenRoversPosition_WhenTurnRightCalled_ThenIncreaseX() {
            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.EAST);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 6);
            assertEquals(expectedPosition.positionY(), 5);
        }

        @Test
        public void givenRoversPosition_WhenTurnLeftCalled_ThenDecreaseX() {
            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.WEST);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 4);
            assertEquals(expectedPosition.positionY(), 5);
        }

        @Test
        public void givenRoversPosition_WhenSequenceOfCommandsReceived_thenReturnFinalPosition() {
            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.NORTH,
                    DirectionEnum.EAST, DirectionEnum.SOUTH, DirectionEnum.EAST, DirectionEnum.NORTH,
                    DirectionEnum.WEST, DirectionEnum.SOUTH);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 5);
            assertEquals(expectedPosition.positionY(), 4);

        }

    }

    @Nested
    class MoveFailure {

        @Test
        public void givenRoversPositionAndLastMoveBackwards_WhenMoveForwardCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.EAST, DirectionEnum.SOUTH,
                    DirectionEnum.NORTH, DirectionEnum.WEST);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 6);
            assertEquals(expectedPosition.positionY(), 5);
        }

        @Test
        public void givenRoversPositionAndLastMoveForward_WhenMoveBackwardsCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.EAST, DirectionEnum.NORTH,
                    DirectionEnum.SOUTH, DirectionEnum.WEST);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 6);
            assertEquals(expectedPosition.positionY(), 5);
        }

        @Test
        public void givenRoversPositionAndLastMoveRight_WhenTurnLeftCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.NORTH, DirectionEnum.EAST,
                    DirectionEnum.WEST, DirectionEnum.SOUTH);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 6);
            assertEquals(expectedPosition.positionY(), 5);
        }

        @Test
        public void givenRoversPositionAndLastMoveLeft_WhenTurnRightCalled_ThenStopAndStayStill() {

            // Given
            var position = new Position(5,5);
            List<DirectionEnum> commands = List.of(DirectionEnum.NORTH, DirectionEnum.WEST,
                    DirectionEnum.EAST, DirectionEnum.SOUTH);

            // When
            var expectedPosition = moveCommand.move(position, commands);

            // Then
            assertEquals(expectedPosition.positionX(), 6);
            assertEquals(expectedPosition.positionY(), 5);
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
