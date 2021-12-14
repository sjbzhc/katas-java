package chapter04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindBuildOrder {

    public Stack<Project> findBuildOrder(String [] projects, String[][] dependencies) {
        ProjectGraph g = buildGraph(projects, dependencies);
        return null;
    }

    public ProjectGraph buildGraph(String[] projects, String[][] dependencies) {
        ProjectGraph graph = new ProjectGraph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }
}
