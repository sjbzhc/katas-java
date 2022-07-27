package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */
public class PairsOfSongs {
    public int numPairsDivisibleBy60(int[] songs) {
        int[] complements = new int[60];
        int count = 0;

        for (int s : songs) {
            if (s % 60 == 0) {
                count += complements[0];
            } else {
                count += complements[getComplement(s)];
            }
            complements[s % 60]++;
        }

        return count;
    }

    private int getComplement(int s) {
        // s = 40, we want to get 20
        return 60 - (s % 60);
    }
}
