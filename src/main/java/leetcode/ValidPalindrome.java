package leetcode;

import java.util.List;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.equals(" ")) return true;
        String clean = s.toLowerCase().replaceAll("[^a-z]", "");
        int i = 0;
        int j = clean.length() - 1;
        System.out.print('s');
        System.out.print(clean);
        System.out.println('e');
        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
