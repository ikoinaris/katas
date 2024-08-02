package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarsRover {

    private int positionX;
    private int positionY;
    private char direction;

    public void moveCommands(char[] commands) {
        for (char command : commands) {
            switch (command) {
                case 'F':
                    moveForward();
                    break;
                case 'B':
                    moveBackwards();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
            }
        }
    }

    public void moveForward() {
        switch (direction) {
            case 'N':
                positionY++;
                break;
            case 'S':
                positionY--;
                break;
            case 'E':
                positionX++;
                break;
            case 'W':
                positionX--;
                break;
        }
    }

    public void moveBackwards() {
        switch (direction) {
            case 'N':
                positionY--;
                break;
            case 'S':
                positionY++;
                break;
            case 'E':
                positionX--;
            case 'W':
                positionX++;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }
}
