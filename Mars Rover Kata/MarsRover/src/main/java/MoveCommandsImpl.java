import java.util.List;

public class MoveCommandsImpl implements MoveCommands {

    @Override
    public Position move(Position position, List<DirectionEnum> directions) {
        var newPosition = new Position(0,0);
        for(int i = 0; i < directions.size(); i++) {
            var direction = directions.get(i);
            var previousDirection = (i > 0) ? directions.get(i - 1) : direction;
            switch(direction) {
                case NORTH -> {
                    if (!previousDirection.equals(DirectionEnum.SOUTH)){
                        newPosition = moveForward(position);
                    }
                }
                case SOUTH -> {
                    if (!previousDirection.equals(DirectionEnum.NORTH)){
                        newPosition = moveBackward(position);
                    }
                }
                case EAST -> {
                    if (!previousDirection.equals(DirectionEnum.WEST)){
                        newPosition = turnRight(position);
                    }
                }
                case WEST -> {
                    if (!previousDirection.equals(DirectionEnum.EAST)){
                        newPosition = turnLeft(position);
                    }
                }
            }
        }
        return newPosition;
    }


    private Position moveForward(Position position) {
        return new Position(position.positionX(), position.positionY() + 1);
    }

    private Position moveBackward(Position position) {
        return new Position(position.positionX(), position.positionY() - 1);
    }

    private Position turnLeft(Position position) {
        return new Position(position.positionX() - 1, position.positionY());
    }

    private Position turnRight(Position position) {
        return new Position(position.positionX() + 1, position.positionY());
    }
}
