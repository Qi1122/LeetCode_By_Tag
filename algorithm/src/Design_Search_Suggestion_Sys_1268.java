/*
https://leetcode.com/problems/search-suggestions-system/
 */
package algorithm.src;
import java.util.*;
public class Design_Search_Suggestion_Sys_1268 {
    class TrieNode {
        TrieNode[] children;
        List<String> words;
        TrieNode() {
            this.children = new TrieNode[26];
            this.words = new ArrayList<>();
        }
    }

    private TrieNode root = new TrieNode();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) insert(product);
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(startWith(searchWord.substring(0, i + 1)));
        }
        return res;
    }

    private void insert(String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c -'a'] = new TrieNode();
            node = node.children[c - 'a'];
            if (node.words.size() < 3) node.words.add(product);
        }
    }

    private List<String> startWith (String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return node.words;
            //if (node.children[c - 'a'] == null) return Collections.EMPTY_LIST;
            node = node.children[c - 'a'];
        }
        return node.words;
    }
}
