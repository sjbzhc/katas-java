package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n)
* Space: O(n)
* */

public class KthFactor {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n/2 + 1; i++) {
            if (n%i == 0) {
                factors.add(i);
            }

            if (factors.size() == k) {
                return factors.get(k-1);
            }

        }
        return -1;
    }
}
