package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystemTests {
    @Test
    public void search_suggestion() {
        SearchSuggestionSystem ss = new SearchSuggestionSystem();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};

        List<List<String>> lists = new ArrayList<>();
        List<String> l1 = List.of("mobile","moneypot","monitor");
        List<String> l2 = List.of("mobile","moneypot","monitor");
        List<String> l3 = List.of("mouse","mousepad");
        List<String> l4 = List.of("mouse","mousepad");
        List<String> l5 = List.of("mouse","mousepad");
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        lists.add(l5);

        Assertions.assertThat(ss.suggestedProducts(products, "mouse")).isEqualTo(lists);
    }

    @Test
    public void search_suggestion_2() {
        SearchSuggestionSystem ss = new SearchSuggestionSystem();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};

        List<List<String>> lists = new ArrayList<>();
        List<String> l1 = List.of("mobile","moneypot","monitor");
        List<String> l2 = List.of("mobile","moneypot","monitor");
        List<String> l3 = List.of("mouse","mousepad");
        List<String> l4 = List.of("mouse","mousepad");
        List<String> l5 = List.of("mouse","mousepad");
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        lists.add(l5);

        Assertions.assertThat(ss.suggestedProducts2(products, "mouse")).isEqualTo(lists);
    }

    @Test
    public void search_suggestion_2_1() {
        SearchSuggestionSystem2 ss = new SearchSuggestionSystem2();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};

        List<List<String>> lists = new ArrayList<>();
        List<String> l1 = List.of("mobile","moneypot","monitor");
        List<String> l2 = List.of("mobile","moneypot","monitor");
        List<String> l3 = List.of("mouse","mousepad");
        List<String> l4 = List.of("mouse","mousepad");
        List<String> l5 = List.of("mouse","mousepad");
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        lists.add(l5);

        Assertions.assertThat(ss.suggestedProducts(products, "mouse")).isEqualTo(lists);
    }
}
