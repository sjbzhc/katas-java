package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n)
* Space: O(n)
* */

public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            while (s.charAt(r) != '#') r++;
            int len = Integer.valueOf(s.substring(l, r));
            res.add(s.substring(r + 1, r + 1 + len));
            l = r + 1 + len;
            r = l;
        }

        return res;
    }
}
