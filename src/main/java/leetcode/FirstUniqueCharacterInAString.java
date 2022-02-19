package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0;i<str.length();i++) {
            if (map.get(str.charAt(i)).equals(1)) return i;
        }

        return -1;
    }
}
