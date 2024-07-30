import java.util.List;

public interface MoveCommands {

    Position move(Position position, List<DirectionEnum> directions);
}
