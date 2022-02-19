package leetcode.robotRoomCleaner;

import java.util.HashSet;
import java.util.Set;

/*
* Time: O(n - m): number of cells n - number of obstacles m
* Space: O(n - m): visited set
* Uses backtracking.
* The idea is to launch "journeys" to all 4 directions in the for loop, as each of the 4 directions will be checked.
* Once we check the 4 directions, we turn
* */

public class RobotRoomCleaner {
    int[] yOffsets = {-1,0,1,0};
    int[] xOffsets = {0,1,0,-1};

    public void cleanRoom(Robot robot) {
        backtrack(robot, 0, 0, 0, new HashSet<>());
    }

    private void backtrack(Robot robot, int x, int y, int curDirection, Set<String> visited) {
        robot.clean();
        visited.add(x + " " + y);

        for (int d=0;d<4;d++) {
            int nDirection = (curDirection + d) % 4;
            int nx = xOffsets[nDirection] + x;
            int ny = yOffsets[nDirection] + y;
            if (!visited.contains(nx + " " + ny) && robot.move()) {
                backtrack(robot, nx, ny, nDirection % 4, visited);
                goBack(robot);
            }

            robot.turnRight();

        }

    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
