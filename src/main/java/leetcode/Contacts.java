package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {

    class Trie {
        int count = 0;
        Map<Character, Trie> children = new HashMap<>();
    }

    Trie root = new Trie();

    public void addWord(String w) {
        Trie current = root;
        for (char c : w.toCharArray()) {
            current.children.putIfAbsent(c, new Trie());
            current.count++;
            current = current.children.get(c);
        }
    }

    public int findWord(String w) {
        Trie current = root;
        for (char c : w.toCharArray()) {
            if (!current.children.containsKey(c)) return 0;
            current = current.children.get(c);
        }
        return current.count;
    }
    public List<Integer> contacts(List<List<String>> queries) {
        List<String> contacts = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (List<String> query : queries) {
            String instruction = query.get(0);
            String val = query.get(1);

            if (instruction.equals("add")) addWord(val);
            if (instruction.equals("find")) res.add(findWord(val));

        }
        return res;
    }
}
