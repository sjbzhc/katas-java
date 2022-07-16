package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ReconstructItineraryTests {
    @Test
    public void test() {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> tickets = List.of(List.of("MUC","LHR"), List.of("JFK","MUC"), List.of("SFO","SJC"), List.of("LHR","SFO"));
        List<String> result = List.of("JFK","MUC","LHR","SFO","SJC");

        Assertions.assertThat(ri.findItinerary(tickets)).isEqualTo(result);
    }

    @Test
    public void test2() {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> tickets = List.of(
                List.of("EZE","AXA") ,List.of("TIA","ANU") ,List.of("ANU","JFK") ,List.of("JFK","ANU")
                ,List.of("ANU","EZE") ,List.of("TIA","ANU") ,List.of("AXA","TIA") ,List.of("TIA","JFK")
                ,List.of("ANU","TIA") ,List.of("JFK","TIA")
        );
        List<String> result = List.of("JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK");

        Assertions.assertThat(ri.findItinerary(tickets)).isEqualTo(result);
    }


}
