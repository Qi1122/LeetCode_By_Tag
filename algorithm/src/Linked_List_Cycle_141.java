/*
 Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
         val = x;
         next = null;
    }
 }
 1. create map
 2. iterate linked list
 if !map.contains(node) -> put
 else return true
 */
import java.lang.*;
import java.util.HashMap;

public class Linked_List_Cycle_141 {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, 1);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
