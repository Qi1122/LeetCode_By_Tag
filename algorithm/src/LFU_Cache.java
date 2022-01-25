/*
LC link:
https://leetcode.com/problems/lfu-cache/

LC map + DLL solution link: (well explained)
https://leetcode.com/problems/lfu-cache/discuss/1365737/Java-O(1)-Solution-with-detailed-explaination-(2-hashMaps-%2B-1-DLL)

LC map + DLL + Heap solution link:
https://leetcode.com/problems/lfu-cache/discuss/478926/Java-Using-Double-Linked-List-Hashmap-and-Heap
 */
package algorithm.src;
import java.util.*;

public class LFU_Cache {

    private final int CAPACITY;
    private int curSize;
    private int minFreq;
    private Map<Integer, ListNode> cache;
    private Map<Integer, DoubleLinkedList> freqMap;

    public LFU_Cache(int capacity) {
        this.CAPACITY = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            updateNode(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (CAPACITY == 0) return;
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.val = value;
            updateNode(node);
        } else {
            curSize++;
            if (curSize > CAPACITY) {
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFreq = 1;
            ListNode newNode = new ListNode(key, value);
            DoubleLinkedList curList = freqMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(ListNode node) {
        int curFreq = node.freq;
        DoubleLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(node);
        if (curFreq == minFreq && curList.listSize == 0) minFreq++;
        node.freq++;
        DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }

    class ListNode {
        private int key, val, freq;
        ListNode prev = null, next = null;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoubleLinkedList {
        private int listSize;
        private ListNode head, tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new ListNode(-1, -1);
            this.tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(ListNode node) {
            ListNode temp = head.next;
            head.next = node;
            node.next = temp;
            temp.prev = node;
            node.prev = head;
            listSize++;
        }

        private void removeNode(ListNode node) {
            if (node == null) return;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            listSize--;
        }
    }
}
