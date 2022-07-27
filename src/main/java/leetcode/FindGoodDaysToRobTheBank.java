package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List res = new ArrayList<>();
        int n = security.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=1; i < n; i++){
            if(security[i] <= security[i-1]) {
                left[i] = 1 + left[i-1];
            }
        }

        for(int i = n-2; i >= 0; i--) {
            if(security[i]<=security[i+1]) {
                right[i] = 1 + right[i+1];
            }
        }

        for(int i=time; i < n-time; i++){
            if(left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
