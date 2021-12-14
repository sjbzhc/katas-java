package chapter04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectGraph {
    public ArrayList<Project> nodes = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(node.getName(), node);
        }

        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = new Project(startName);
        Project end = new Project(endName);
        start.addNeighbor(end);
    }
}
