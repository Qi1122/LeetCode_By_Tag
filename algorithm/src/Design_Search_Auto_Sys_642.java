/*
https://leetcode.com/problems/design-search-autocomplete-system/
 */
import java.util.*;

class Design_Search_Auto_Sys_642 {

    class TrieNode {
        private TrieNode[] children;
        private Map<String, Integer> countSentences;

        TrieNode() {
            children = new TrieNode[128];
            this.countSentences = new HashMap<>();
        }
    }

    private TrieNode root;
    private String buffer;
    private static final int TOP = 3;

    public Design_Search_Auto_Sys_642(String[] sentences, int[] times) {
        this.root = new TrieNode();
        for (int i = 0; i<sentences.length; i++) insert(sentences[i], times[i]);
        buffer = "";
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(buffer, 1);
            buffer = "";
            return new ArrayList<>();
        }
        buffer += c;
        return search(buffer);
    }

    private void insert(String sentence, int times) {
        TrieNode node = root;
        for (char c: sentence.toCharArray()) {
            if (node.children[c] == null) node.children[c] = new TrieNode();
            node = node.children[c];
            node.countSentences.put(sentence, node.countSentences.getOrDefault(sentence, 0) + times);
        }
    }

    private List<String> search(String buffer) {
        TrieNode node = root;
        for (char c: buffer.toCharArray()) {
            if (node.children[c] == null) return new ArrayList<>();
            node = node.children[c];
        }
        return getTopSentences(node.countSentences);
    }

    private List<String> getTopSentences(Map<String, Integer> countSentences ) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) :
                        b.getValue() - a.getValue()));
        pq.addAll(countSentences.entrySet());

        List<String> res = new ArrayList<>();
        int k = 0;
        while (k < TOP && !pq.isEmpty()) {
            res.add(pq.poll().getKey());
            k++;
        }
        return res;
    }
}