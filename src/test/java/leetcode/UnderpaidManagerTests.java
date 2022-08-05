package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class UnderpaidManagerTests {
    @Test
    public void test() {
        UnderpaidManager up = new UnderpaidManager();

        UnderpaidManager.Node n1 = new UnderpaidManager.Node(100);
        UnderpaidManager.Node n2 = new UnderpaidManager.Node(100);
        UnderpaidManager.Node n3 = new UnderpaidManager.Node(200);

        n1.reports.add(n2);
        n1.reports.add(n3);

        Assertions.assertThat(up.countUnderpaid(n1)).isEqualTo(1);

    }

    @Test
    public void test_2() {
        UnderpaidManager up = new UnderpaidManager();

        UnderpaidManager.Node n1 = new UnderpaidManager.Node(100);
        UnderpaidManager.Node n2 = new UnderpaidManager.Node(90);
        UnderpaidManager.Node n22 = new UnderpaidManager.Node(130);
        UnderpaidManager.Node n3 = new UnderpaidManager.Node(90);
        UnderpaidManager.Node n4 = new UnderpaidManager.Node(95);
        UnderpaidManager.Node n5 = new UnderpaidManager.Node(95);

        n1.reports.add(n2);
        n1.reports.add(n22);
        n1.reports.add(n3);
        n3.reports.add(n4);
        n3.reports.add(n5);

        Assertions.assertThat(up.countUnderpaid(n1)).isEqualTo(2);

    }
}
