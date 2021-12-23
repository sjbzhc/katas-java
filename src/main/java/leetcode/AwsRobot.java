package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AwsRobot {
    public boolean isValid(int[][] timeSeries, int numberOfRobots) {
        // Check if the number of robots is the same
        for (int row = 0; row < timeSeries.length; row++) {
            if (Arrays.stream(timeSeries[row]).sum() != numberOfRobots) return false;

        }

        int[] robotIndecesCur = getRobotIndeces(timeSeries[0], numberOfRobots);

        for (int row = 1; row < timeSeries.length; row++) {
            int[] robotIndecesNext = getRobotIndeces(timeSeries[row], numberOfRobots);
            if (!isValidPath(robotIndecesCur, robotIndecesNext)) {
                return false;
            }
            robotIndecesCur = robotIndecesNext;
        }

        return true;
    }

    private boolean isValidPath(int[] currentPositions, int[] nextPositions) {
        for (int i=0; i< currentPositions.length;i++) {
            if (Math.abs(currentPositions[i] - nextPositions[i]) > 1) {
                return false;
            }
        }
        return true;
    }

    private int[] getRobotIndeces(int[] row, int numberOfRobots) {
        int[] robotPositions = new int[numberOfRobots];
        int currentRobot = 0;
        for (int i=0; i<row.length;i++) {
            if (row[i] == 1) {
                robotPositions[currentRobot] = i;
                currentRobot++;
            }
        }
        return robotPositions;
    }
}
