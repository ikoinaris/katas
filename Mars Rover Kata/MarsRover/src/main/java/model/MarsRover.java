package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarsRover {

    private int positionX;
    private int positionY;
    private char direction;
    private int[][] obstaclePositions;
    private int planetHeight;
    private int planetWidth;

    public MarsRover(int positionX, int positionY, char direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

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
                positionY = positionY + 1;
                break;
            case 'S':
                positionY = positionY - 1;
                break;
            case 'E':
                positionX = positionX + 1;
                break;
            case 'W':
                positionX = positionX - 1;
                break;
        }
    }

    public void moveBackwards() {
        switch (direction) {
            case 'N':
                positionY = positionY - 1;
                break;
            case 'S':
                positionY = positionY + 1;
                break;
            case 'E':
                positionX = positionX - 1;
                break;
            case 'W':
                positionX = positionX + 1;
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

    private boolean obstacleDetected(int posX, int posY) {
        for (int[] obstaclePosition : obstaclePositions) {
            if (obstaclePosition[0] == posX && obstaclePosition[1] == posY) {
                return true;
            }
        }
        return false;
    }
}
