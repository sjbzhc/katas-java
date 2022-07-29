package leetcode;

import java.util.*;

/*
* Time: O(n4)
* Space: O(n log n)
* */

public class AnalyseUserWebsiteVisitPattern {
    class Visit {
        String username;
        int timestamp;
        String website;

        public Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }
        visits.sort((a, b) -> a.timestamp - b.timestamp);
        Map<String, List<String>> userToWebsites = new HashMap<>();

        for (Visit visit : visits) {
            if (!userToWebsites.containsKey(visit.username)) {
                userToWebsites.put(visit.username, new ArrayList<>());
            }
            userToWebsites.get(visit.username).add(visit.website);
        }

        Map<String, Integer> patternToFrequency = new HashMap<>();

        for (String user : userToWebsites.keySet()) {
            for (String pattern : generatePatterns(userToWebsites.get(user))) {
                patternToFrequency.put(pattern, patternToFrequency.getOrDefault(pattern, 0) + 1);
            }
        }

        int max = 0;
        String maxPattern = "";

        for (String pattern : patternToFrequency.keySet()) {
            int frequency = patternToFrequency.get(pattern);
            if (frequency > max) {
                max = frequency;
                maxPattern = pattern;
            } if (frequency == max) {
                maxPattern = maxPattern.compareTo(pattern) > 0 ? pattern : maxPattern;
            }
        }

        return Arrays.asList(maxPattern.split("#"));
    }

    private Set<String> generatePatterns(List<String> websites) {
        Set<String> patterns = new HashSet<>();
        if (websites.size() < 3) return patterns;
        backtrack(websites, 0, new ArrayList<>(), patterns);
        return patterns;
    }

    // Generate all 3-permutations with backtracking
    private void backtrack(List<String> websites, int index, List<String> currentWebsites, Set<String> patterns) {
        if (currentWebsites.size() == 3) {
            String seq = currentWebsites.get(0) + "#" + currentWebsites.get(1) + "#" + currentWebsites.get(2);
            if (!patterns.contains(seq)) {
                patterns.add(seq);
            }
            return;
        }

        for (int i = index; i < websites.size(); i++) {
            currentWebsites.add(websites.get(i));
            backtrack(websites, i + 1, currentWebsites, patterns);
            currentWebsites.remove(currentWebsites.size() - 1);
        }
    }
}
