/*
https://leetcode.com/problems/k-closest-points-to-origin/
1. create a max pq with size k
2. scan matrix -> calculate distance of each point to (0,0)
    -> compare with pq.poll() -> if curr < pq.poll() -> add to pq
3. use int[] to store final result in pq
*/
import java.util.*;

public class PQ_K_Cloest_Points_973 {
    public int[][] kClosest(int[][] points, int k) {
        //max pq, comparator, -> for loop
        // PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        //     @Override
        //     //o1 - o2 -> minHeap
        //     //o2 - o1 -> maxHeap
        //     public int compare(int[] o1, int[] o2) {
        //         int distacneOne = o1[0] * o1[0] + o1[1] * o1[1];
        //         int distanceTwo = o2[0] * o2[0] + o2[1] * o2[1];
        //         return distanceTwo - distacneOne;
        //     }
        // });
        //lambda function
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o2[2] - o1[2]);
        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            pq.offer(new int[]{cur[0], cur[1], distance(cur)});
            if (pq.size() > k) pq.poll();
        }
        // while (!pq.isEmpty()) {
        //     int[] temp = pq.poll();
        //     System.out.println(temp[0] + " " + temp[1]);
        // }
        // sol 1:
        // int[][] res = new int[k][2];
        // for (int i = 0; i < k; i++) {
        //     int[] top = pq.poll();
        //     res[i][0] = top[0];
        //     res[i][1] = top[1];
        // }
        //sol 2:
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            int[] top = pq.poll();
            res[i] = new int[]{top[0], top[1]};
        }
        return res;
    }

    private int distance(int[] o1) {
        return o1[0] * o1[0] + o1[1] * o1[1];
    }
}
