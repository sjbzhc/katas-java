package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String prevString = countAndSay(n-1);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int ptr = 0;

        while (ptr < prevString.length()) {
            count++;
            char current = prevString.charAt(ptr);

            if (ptr + 1 >= prevString.length() || current != prevString.charAt(ptr + 1)) {
                sb.append(count);
                sb.append(current);
                count = 0;
            }

            ptr++;
        }

        return sb.toString();
    }
}
