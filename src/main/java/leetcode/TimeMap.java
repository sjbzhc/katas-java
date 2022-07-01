package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Time: O(log n)
* Space: O(n)
* */

public class TimeMap {

    class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String res = "";
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());

        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (list.get(m).timestamp <= timestamp) {
                res = list.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
