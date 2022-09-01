package leetcode;

import java.util.TreeMap;

/*
* We get the keys before and after start
* By definition, any element stored in the TreeMap will have a start >= the end of the prev key and
* an end < start of next key
*
* If the start of the new slot is greater equal than the end of the preceding slot AND
* the end of the new slot is smaller equal to the next start
* Also consider the cases where there are no prev or next elements
*
* Time: O(n log n)
* Space: O(n)
* */

public class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);

        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
