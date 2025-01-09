package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n)
* Space: O(n)
* */

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;

        for (int r=0; r<s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            /*
            * r - l + 1  = maxInstanceCount + rest => rest = r - l + 1 - maxInstanceCount
            * if the rest (not the char with the highest instance count) is larger than k,
            * we cannot replace the rest of the characters with the same as maxInstanceCount
            * */
            if ((r - l + 1) - Collections.max(map.values()) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
