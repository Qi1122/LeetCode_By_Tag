/*
https://leetcode.com/problems/top-k-frequent-elements/

map iterator:
https://www.baeldung.com/java-iterate-map
 */
import java.util.*;

public class PQ_Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        //key: nums[i] value: frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //min pq: nums[i], frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            //comparator return type int
            @Override
            //min heap: o1 - o2
            //int[] {nums[i], frequency}
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //add to pq
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
