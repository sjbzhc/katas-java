package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* We are only looking for one of many solutions.
* We start with 2 and we increase the currNum by 2 in the loop. At the same time we decrease finalSum by currNum
* At the end we will have one case where currNum > finalSum. To account for this, we get the last added element
* to res, add finalSum to it and add it back to res
*
* Time: O(sqrt(n))
* Space: O(sqrt(n))
* */
public class MaximumSplitOfPositiveEvenIntegers {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if(finalSum % 2 != 0) return res;

        long currNum = 2;

        while (currNum <= finalSum) {
            res.add(currNum);
            finalSum -= currNum;
            currNum += 2;
        }

        long last = res.remove(res.size() - 1);
        res.add(last + finalSum);
        return res;
    }
}
