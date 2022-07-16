package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) return -1;

        int total = 0;
        int index = 0;
        for (int i=0; i<gas.length; i++) {
            total = total + gas[i] - cost[i];

            // if we come here, it means the current element is not the solution
            // it must be further right, since we are guaranteed to have one solution
            if (total < 0) {
                total = 0;
                index++;
            }
        }
        return index;
    }

    public int sum(int[] arr) {
        int res = 0;
        for (int n : arr) res += n;
        return res;
    }
}
