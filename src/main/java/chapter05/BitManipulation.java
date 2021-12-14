package chapter05;

public class BitManipulation {

    public int clearBitsThroughI(int num, int i) {
        // shift i positions, from left to right: 1 << 3 => 1000
        int mask = (1 << i);
        // removes the MSB and flips all 0s: 1000 => 111
        mask -= 1;
        // Gets rid of the first left of the number (as only 111 will be passed, so all in positions with 0s won't be passed 00000111)
        return num & mask;
    }

    public int clearBitsThrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }
}
