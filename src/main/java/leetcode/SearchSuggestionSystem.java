package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        StringBuilder sb = new StringBuilder();
        List<List<String>> lists = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            lists.add(createList(products, sb.toString()));
        }
        return lists;
    }

    private List<String> createList(String[] products, String searchWord) {
        List<String> list = Arrays.stream(products)
                .filter(product -> product.startsWith(searchWord))
                .sorted()
                .collect(Collectors.toList());
        if (list.size() > 3) {
            return list.subList(0,3);
        }
        return list;
    }

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0;
        int n = products.length;
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;
            start = lowerBound(products, start, prefix);
            result.add(new ArrayList<>());

            for (int i = start; i<Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].startsWith(prefix)) {
                    break;
                }
                result.get(result.size() -1).add(products[i]);
            }
        }
        return result;
    }

    private int lowerBound(String[] products, int start, String prefix) {
        int i = start;
        int j = products.length;
        int mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(prefix) >= 0) {
                j = mid;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    }
}
