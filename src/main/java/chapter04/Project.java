package chapter04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Project {

    public enum State { COMPLETE, PARTIAL, BLANK }
    private ArrayList<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();
    private String name;
    public State state = State.BLANK;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if(!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public String getName() {
        return name;
    }

    public Project(ArrayList<Project> children) {
        this.children = children;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
