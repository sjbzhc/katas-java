package leetcode;

import java.util.*;

public class LettersThatOccurMost {
    public Map<Character, Set<Character>> lettersThatOccurMost(List<String> strings) {
        Map<Character, Map<Character, Integer>> charToNeighborFrequencyMap = new HashMap<>();

        for(String str : strings) {
            for(int i=0; i<str.length(); i++) {
                charToNeighborFrequencyMap.putIfAbsent(str.charAt(i), new HashMap<>());
                Map<Character, Integer> neighbors = charToNeighborFrequencyMap.get(str.charAt(i));
                for(int j=0; j<str.length(); j++) {
                    if(i == j) {
                        continue;
                    }
                    neighbors.put(str.charAt(j), neighbors.getOrDefault(str.charAt(j), 0)+1);
                }
            }
        }

        Map<Character, Set<Character>> result = new HashMap<>();
        for(Character c : charToNeighborFrequencyMap.keySet()) {
            List<Map.Entry<Character, Integer>> entries = new ArrayList<>(charToNeighborFrequencyMap.get(c).entrySet());
            Collections.sort(entries, (a, b) -> b.getValue()-a.getValue());

            result.putIfAbsent(c, new HashSet<>());
            int countMostFrequentNeighbor = entries.get(0).getValue();
            for(Map.Entry<Character, Integer> entry : entries) {
                if(entry.getValue() == countMostFrequentNeighbor)
                    result.get(c).add(entry.getKey());
            }
        }
        System.out.println(result);
        return result;
    }
}
