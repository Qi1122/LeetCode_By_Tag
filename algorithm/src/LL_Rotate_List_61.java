/*
https://leetcode.com/problems/rotate-list/

Algo:
1. create tail which point to head
2. find tail and len by iterating linked list
3. tail.next = head -> create circle
4. find how many actual move needed -> move = len - k % len;
5. move head and tail
6. tail.next = null to break circle and return head
 */
package algorithm.src;

public class LL_Rotate_List_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        //find tail and len
        while (tail.next != null) { ++len; tail = tail.next; }
        tail.next = head;
        int move = len - k % len;
        while (move != 0) {
            tail = head;
            head = head.next;
            move--;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        LL_Rotate_List_61 sol = new LL_Rotate_List_61();
        ListNode head = sol.createList();
    }

    public ListNode createList() {
//        ListNode three = new ListNode(3);
//        ListNode two = new ListNode(2, three);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);
        ListNode zero = new ListNode(0, one);
        return zero;
    }

    public class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {this.val = val;}
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
