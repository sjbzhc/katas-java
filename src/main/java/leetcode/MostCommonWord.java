package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
* Time: O(n + m) n: chars in input, m: chars in banned list
* Space: O(n)
* */

/*
Stream and then:
split by space
to lowercase
remove trailing , or .
create frequency list
find max in freq list
*/

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();

        for (String w : banned) {
            bannedSet.add(w);
        }

        List<String> list = Arrays.stream(
                paragraph.replaceAll("[^a-zA-Z0-9 ]", " ")
                        .toLowerCase().split("\\s+")
        )
            .filter((w) -> !bannedSet.contains(w))
            .collect(Collectors.toList());

        Map<String, Integer> stringToFreq = new HashMap<>();

        for (String w : list) {
            stringToFreq.put(w, stringToFreq.getOrDefault(w, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String res = "";

        for (String w : list) {
            if (stringToFreq.get(w) > max) {
                res = w;
                max = stringToFreq.get(w);
            }
        }

        return res;
    }
}
