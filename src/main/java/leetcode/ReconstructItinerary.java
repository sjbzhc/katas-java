package leetcode;

import java.util.*;

/*
* Time: O(E^2): E: number of flights, d max number of flights for an airport
* Space: O(V + E)
* */
public class ReconstructItinerary {
    HashMap<String, List<String>> adjacencyList = new HashMap<>();
    HashMap<String, boolean[]> visitedByOrigin = new HashMap<>();
    int n = 0;
    List<String> result = null;


    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adjacencyList.putIfAbsent(src, new ArrayList<>());
            adjacencyList.get(src).add(dest);
        }

        for (List<String> l : adjacencyList.values()) Collections.sort(l);
        for (String key : adjacencyList.keySet()) visitedByOrigin.put(key, new boolean[adjacencyList.get(key).size()]);

        n = tickets.size();

        backtracking("JFK", new ArrayList<>(List.of("JFK")));
        return result;
    }

    protected boolean backtracking(String origin, List<String> route) {
        if (route.size() == n + 1) {
            result = new ArrayList<>(route);
            return true;
        }

        boolean[] visitedFromOrigin = visitedByOrigin.get(origin);
        List<String> neighbors = adjacencyList.getOrDefault(origin, new ArrayList<>());

        for (int i=0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            // Can only visit once
            if (!visitedFromOrigin[i]) {
                visitedFromOrigin[i] = true;
                route.add(neighbor);

                if (backtracking(neighbor, route)) return true;

                route.remove(route.size() - 1);
                visitedFromOrigin[i] = false;
            }
        }
        return false;
    }
}
