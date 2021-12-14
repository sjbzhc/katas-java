package leetcode.robotRoomCleaner;

public class Robot implements IRobot {
    // up, right, down, left
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int currentDirection = 0;
    @Override
    public boolean move() {
        return false;
    }

    @Override
    public void turnLeft() {
        if (currentDirection == 0) {
            currentDirection = 3;
        } else {
            currentDirection--;
        }
    }

    @Override
    public void turnRight() {
        if (currentDirection == 3) {
            currentDirection = 0;
        } else {
            currentDirection++;
        }
    }

    @Override
    public void clean() {
    }
}
