package leetcode;

import java.util.*;

/*
* Time: O(E log E)
* Space: O(E + V) with V = result list
* */
public class ReconstructItinerary {
    // Step 1: Build the adjacency list using a priority queue
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            graph.putIfAbsent(src, new PriorityQueue<>());
            graph.get(src).offer(dest);
        }

        // Step 2: Use DFS or a stack to construct the itinerary
        // The stack will be used to simulate the DFS traversal
        dfs("JFK");


        // Step 3: Reverse the result since we're adding destinations in a post-order manner
        Collections.reverse(result);
        return result;
    }

    // Step 4: Depth First Search (DFS) for itinerary construction
    private void dfs(String airport) {
        // While there are destinations for the current airport
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            // Get the lexicographically smallest destination
            String nextAirport = graph.get(airport).poll();
            // Recursively visit this destination
            dfs(nextAirport);
        }
        // After all neighbors are visited, add the airport to the result
        result.add(airport);
    }

    /*
     * Time: O(E^2): E: number of flights, d max number of flights for an airport
     * Space: O(V + E)
     * */
    HashMap<String, List<String>> adjacencyList = new HashMap<>();
    HashMap<String, boolean[]> visitedByOrigin = new HashMap<>();
    int n = 0;
    List<String> result = null;



    public List<String> findItineraryBacktracking(List<List<String>> tickets) {
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
