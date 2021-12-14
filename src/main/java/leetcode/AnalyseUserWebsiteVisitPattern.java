package leetcode;

import java.util.*;

public class AnalyseUserWebsiteVisitPattern {

    class Visit {
        private String user;
        private int timestamp;
        private String website;

        public Visit(String user, int timestamp, String website) {
            this.user = user;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Visit> visits = new ArrayList<>();
        for (int i=0; i< username.length;i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }
        Comparator<Visit> comparator = (v1, v2) -> v1.timestamp - v2.timestamp;
        Collections.sort(visits, comparator);

        // Maps a user to all their visited websites
        Map<String, List<String>> userToWeb = new HashMap<>();

        for (Visit v : visits) {
            if (!userToWeb.containsKey(v.user)) {
                userToWeb.put(v.user, new ArrayList<>());
            }
            userToWeb.get(v.user).add(v.website);
        }

        Map<String, Integer> webToFrequency = new HashMap<>();
        // For all users, get all their visit sequences. Count in webToFrequency how often the sequence appeared throughout all users
        for (String user: userToWeb.keySet()) {
            // Create the sequences for a user's websites
            Set<String> seqs = get3Seq(userToWeb.get(user));
            for (String seq : seqs) {
                webToFrequency.put(seq, webToFrequency.getOrDefault(seq, 0) + 1);
            }
        }
        int max = 0;
        String ans = "";

        for (String seq : webToFrequency.keySet()) {
            int freq = webToFrequency.get(seq);
            if (freq < max) continue;
            if (freq > max) ans = seq;
            if (max == freq) ans = seq.compareTo(ans) < 0 ? seq : ans;
            max = freq;
        }
        return Arrays.asList(ans.split("#"));
    }

    public Set<String> get3Seq(List<String> webs) {
        Set<String> res = new HashSet<>();
        if (webs.size() < 3) return res;
        dfs(webs, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(List<String> webs, int idx, List<String> tmp, Set<String> res) {
        if (tmp.size() == 3) {
            String seq = tmp.get(0) + "#" + tmp.get(1) + "#" + tmp.get(2);
            if (!res.contains(seq)) res.add(seq);
            return;
        }
        for (int i = idx; i < webs.size(); i++) {
            tmp.add(webs.get(i));
            dfs(webs, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
