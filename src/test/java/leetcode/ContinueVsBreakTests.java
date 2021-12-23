package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ContinueVsBreakTests {

    /*
    * i, j: 0, 0
    * i, j: 0, 1
    * i, j: 0, 2
    * i, j: 1, 0
    * i, j: 1, 2
    * i, j: 2, 0
    * i, j: 2, 1
    * i, j: 2, 2
    *
    * 8 lines, with 1,1 skipped
    * */
    @Test
    public void continue_test() {
        for (int i = 0; i<3;i++) {
            for (int j=0;j<3;j++) {
                if (i == 1 && j == 1) continue;
                System.out.println("i, j: " + i + ", " + j);
            }
        }
    }


    /*
    * i, j: 0, 0
    * i, j: 0, 1
    * i, j: 0, 2
    * i, j: 1, 0
    * i, j: 2, 0
    * i, j: 2, 1
    * i, j: 2, 2
    *
    * 7 lines, with 1,1 and 1,2 skipped.
    * */
    @Test
    public void break_test() {
        for (int i = 0; i<3;i++) {
            for (int j=0;j<3;j++) {
                if (i == 1 && j == 1) break;
                System.out.println("i, j: " + i + ", " + j);
            }
        }
    }
}
