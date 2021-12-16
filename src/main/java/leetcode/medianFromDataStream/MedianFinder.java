package leetcode.medianFromDataStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        list.sort((a,b) -> a - b);
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 0) {
            int right = size / 2;
            int left = right - 1;
            return (list.get(left) + list.get(right)) / 2.0;
        }
        return list.get(size/2);
    }
}

