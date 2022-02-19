package chapter04;

import java.util.*;

public class FindBuildOrder {
    int WHITE = 0;
    int GRAY = 1;
    int BLACK = 2;
    boolean isPossible = true;
    Map<String, Integer> visited = new HashMap<>();
    Map<String, List<String>> adjacencyList;
    List<String> result = new ArrayList<>();

    String[] findBuildOrder(String[] projects, String[][] dependencies) {
        adjacencyList = buildAdjacencyList(dependencies);

        for (String project : projects) {
            visited.put(project, WHITE);
        }

        for (String project : projects) {
            if (visited.get(project) == WHITE) {
                dfs(project);
            }
        }

        if (isPossible) {
            String[] finalResult = new String[result.size()];
            int index = 0;
            for (int i=result.size() - 1; i>=0; i--) {
                finalResult[index] = result.get(index);
                index++;
            }
            return finalResult;
        } else {
            return new String[0];
        }

    }

    private void dfs(String project) {
        if (!isPossible) return;

        visited.put(project, GRAY);

        for (String adjacent : adjacencyList.getOrDefault(project, new ArrayList<>())) {
            if (visited.get(adjacent) == WHITE) {
                dfs(adjacent);
            } else if (visited.get(adjacent) == GRAY) {
                isPossible = false;
            }
        }

        visited.put(project, BLACK);
        result.add(project);
    }

    Map<String, List<String>> buildAdjacencyList(String[][] dependencies) {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        for (String[] dependency : dependencies) {
            List<String> list = adjacencyList.getOrDefault(dependency[1], new ArrayList<>());

            if (!list.contains(dependencies[0])) {
                list.add(dependency[0]);
            }

            adjacencyList.put(dependency[1], list);

        }
        return adjacencyList;
    }
}
