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
        int i=0;

        while(i < s.length()) {
            int j=i;
            while (s.charAt(j) != '#') j += 1;
            int len = Integer.valueOf(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return res;
    }
}
