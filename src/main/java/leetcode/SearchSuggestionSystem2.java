package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int n = products.length;
        List<List<String>> result = new ArrayList<>();

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int start = binarySearch(products, prefix, 0);

            List<String> prefixResults = new ArrayList<>();
            for (int i = start; i < Math.min(n, start + 3); i++) {
                if (prefix.length() > products[i].length() || !products[i].startsWith(prefix)) break;
                prefixResults.add(products[i]);
            }
            result.add(prefixResults);
        }
        return result;
    }

    private int binarySearch(String[] products, String prefix, int start) {
        int i = start;
        int j = products.length;
        int mid;

        while (i < j) {
             mid =  (i + j) / 2;
             if (products[mid].compareTo(prefix) < 0) {
                 i = mid + 1;
             } else {
                 j = mid;
             }
         }

        return i;
    }
}
