public class Remove_Elements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
