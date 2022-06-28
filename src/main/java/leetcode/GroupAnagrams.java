package leetcode;

import java.util.*;

/*
* Time: O(nk log k), n for strings iter, k log k for sorting
* Space: O(nk)
* */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            if (!list.contains(str)) list.add(str);
            map.put(key, list);
        }

        List<List<String>> res = new ArrayList<>();

        return new ArrayList<>(map.values());
    }

    public String getKey(String str) {
        char[] copy = str.toCharArray();
        Arrays.sort(copy);
        return String.valueOf(copy);
    }
}
