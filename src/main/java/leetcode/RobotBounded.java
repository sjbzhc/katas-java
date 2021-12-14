package leetcode;

/*
* The condition for returning true is that either we are at 0, 0 or the index is not 0.
*
* If the index is not 0, it means that after at most 4 cycles, the robot will come back to 0,0.
* Whatever brought the robot to point east, will make it point to the south in next iteration, then west and finally north.
* */

public class RobotBounded {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {
                {-1,0},
                {0,-1},
                {1,0},
                {0,1}
        };

        int x = 0;
        int y = 0;

        int index = 0;

        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                index = (index + 1) % 4;
            } else if (c == 'R') {
                index = index == 0 ? 3 : (index - 1);
            }
            else {
                x += directions[index][0];
                y += directions[index][1];
            }
        }

        if ((x == 0 && y ==0) || index != 0) return true;
        return false;
    }
}
