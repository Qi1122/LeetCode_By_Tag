/*
1. Initialize：create a minHeap with all heads of linked list
2. heap.poll() -> if heap.poll() has next -> put next in heap

Key point:
1. lists[i] is HEAD
actual data is:

[1, 2, 3]
 |  |  |
 1  2  3
 |  |  |
 1  2  3
 |  |  |
 1  2  3

2.use "next" to move:
  only need to maintain pq with offer "next node" to pq


Time complexity: O(n * log(list.length))

About PriorityQueue:

PQ.offer() -> O(log(size))
in balanced binary tree, with N nodes, height = log N
heapify -> O(n)
maintain heap -> log n -> balanced binary tree -> use array to implment
*/
import java.util.*;

public class Merge_K_Sorted_Lists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            head.next = cur;
            head = cur;
        }
        return dummy.next;
    }
}
