/*
https://leetcode.com/problems/design-hashmap/
 */

package algorithm.src;

public class API_Design_HashMap {
    Node[] arr;

    public API_Design_HashMap() {
        this.arr = new Node[(int)Math.pow(10, 6) + 1];
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        arr[key] = node;
    }

    public int get(int key) {
        if (arr[key] == null) return -1;
        return arr[key].value;
    }

    public void remove(int key) {
        if (arr[key] != null) arr[key] = null;
        return;
    }

    private class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
