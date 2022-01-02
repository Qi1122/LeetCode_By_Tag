/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/

    if PriorityQueue<Integer/String> -> 默认 minHeap
    if maxHeap， use ：
    private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    pq.size = k, minheap
    do we need to initialize pq in construtor?

    -> depends on giving example, in this case, input can be:
    nums = null
    nums.size < k
    nums.size > k

    too many cases if we do if-else in add

    add simply need to handle the case of adding a value in pq

    -> handle initialize in pq

    constructor HAS NO RETURN!!!!
    constructor initial member -> //initial pq with nums

 */
import java.util.*;

public class PQ_Kth_Largest_Stream_703 {
    private int k;
    private int[] nums;
    private PriorityQueue<Integer> pq;

    public PQ_Kth_Largest_Stream_703(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.pq = new PriorityQueue<>();
        for(int num : nums) {
            maintainPQ(num);
        }
    }

    public int add(int val) {
        maintainPQ(val);
        return pq.peek();
    }

    private void maintainPQ(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
    }
}
