/*
https://leetcode.com/problems/lru-cache/

memory (eg: 1G) -> load data to memory,
senario: * memory -> limited size/capacity
         * keep add -> replace LRU
set/get is one "use" -> operate of data

timestamp

double linked list : node(input key, input value)
    -> head: LRU
    -> tail: recently used

HashMap:
    -> key: input key
    -> value: linked list node(input key, input value)

Get(): delete node from ll -> add node to tail
Put(): 1) in map : in -> update node -> delede node -> add node to tail() [get]
       2) not in map: check capacity -> not full -> add to tail
                                     -> full -> delete head -> add new node to tail
*/

import java.util.*;

class DoubleLinkedList {
    int key;
    int val;
    DoubleLinkedList next = null;
    DoubleLinkedList prev = null;

    public DoubleLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }
    //get, set
}

public class LRU_Cache_146 {
    class LRUCache {
        private HashMap<Integer, DoubleLinkedList> map;
        private DoubleLinkedList head = new DoubleLinkedList(-1, -1); //?
        private DoubleLinkedList tail = new DoubleLinkedList(-1, -1);
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head.next = tail;
            this.tail.prev = head;
        }

        private void addNode(DoubleLinkedList node) {
            map.put(node.key, node);
            DoubleLinkedList temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
        }

        private void removeNode(DoubleLinkedList node) {
            if (node == null) return;
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DoubeLinkedList node = map.get(key);
                removeNode(node);
                addNode(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                removeNode(map.get(key));
            } else if (map.size() == capacity) {
                removeNode(tail.prev);
            }
            addNode(new DoubeLinkedList(key, value));
        }
    }
}
