package algorithm.src;

/*
 1. set dummy node and curr to track current moving node
 2. put current smallest node in new linked list
 3. prev.next = l1 == null ? l2 : l1; to put rest in linked list
 4. return dummy.next
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Merge_Two_Sorted_LinkedList_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
