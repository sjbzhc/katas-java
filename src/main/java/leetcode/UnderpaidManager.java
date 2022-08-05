package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UnderpaidManager {

    static class Node {
        List<Node> reports = new ArrayList<>();
        int salary;

        public Node(int salary) {
            this.salary = salary;
        }
    }

    int res = 0;
    public int countUnderpaid(Node node) {
        dfs(node);
        return res;
    }

    class Data {
        int count;
        int sum;

        public Data(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private Data dfs(Node node) {
        if (node == null) return new Data(0, 0);
        if (node.reports.size() == 0) return new Data(1, node.salary);

        int sum = 0;
        int count = 0;
        for (Node report : node.reports) {
            Data d = dfs(report);
            sum += d.sum;
            count += d.count;
        }

        if (sum / (count + 0.0) > node.salary) res++;

        return new Data(count, sum);
    }
}
