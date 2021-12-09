public class Remove_Duplicates_Sorted_LinkedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return dummy.next;
    }
}
