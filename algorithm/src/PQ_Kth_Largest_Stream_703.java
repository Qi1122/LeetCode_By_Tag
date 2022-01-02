/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/

 */
import java.util.*;

public class PQ_Kth_Largest_Stream_703 {
    private int k;
    private int[] nums;
    //if PriorityQueue<Integer/String> -> 默认 minHeap
    //if maxHeap， use ：
    //private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    //construtor HAS NO RETURN
    //constructor intinial member
    public PQ_Kth_Largest_Stream_703(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        //initial pq with nums
        for(int num : nums) {
            maintainPQ(num);
        }
    }

    public int add(int val) {
        //update pq when val >
        maintainPQ(val);
        return pq.peek();
    }

    private void maintainPQ(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
    }
}
