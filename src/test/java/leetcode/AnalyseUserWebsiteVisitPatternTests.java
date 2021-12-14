package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnalyseUserWebsiteVisitPatternTests {
    @Test
    public void analyse_user_website_visit_pattern() {
        AnalyseUserWebsiteVisitPattern au = new AnalyseUserWebsiteVisitPattern();
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        List<String> expected = new ArrayList();
        expected.add("home");
        expected.add("about");
        expected.add("career");

        Assertions.assertThat(au.mostVisitedPattern(username, timestamp, website)).isEqualTo(expected);
    }

    @Test
    public void analyse_user_website_visit_pattern_2() {
        AnalyseUserWebsiteVisitPattern2 au = new AnalyseUserWebsiteVisitPattern2();
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        List<String> expected = new ArrayList();
        expected.add("home");
        expected.add("about");
        expected.add("career");

        Assertions.assertThat(au.mostVisitedPattern(username, timestamp, website)).isEqualTo(expected);
    }
}
