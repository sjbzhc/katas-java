package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Stack;

public class FindBuildOrderTests {
    @Test
    public void find_build_order() {
        FindBuildOrder fb = new FindBuildOrder();
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[] d1 = {"a", "d"};
        String[] d2 = {"f", "b"};
        String[] d3 = {"b", "d"};
        String[] d4 = {"f", "a"};
        String[] d5 = {"d", "c"};
        String[][] dependencies = {d1, d2, d3, d4, d5};
        Stack stack = new Stack();
        stack.push("f");
        stack.push("e");
        stack.push("a");
        stack.push("b");
        stack.push("d");
        stack.push("c");
        ProjectGraph projectGraph = fb.buildGraph(projects, dependencies);
        System.out.println(projectGraph);
//        Assertions.assertThat(fb.findBuildOrder(projects, dependencies)).isEqualTo(stack);
    }
}
