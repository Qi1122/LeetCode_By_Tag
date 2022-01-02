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
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for (int[] point : points) {
            pq.offer(new int[]{point[0], point[1], distance(point)});
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = pq.poll();
            res[i] = new int[]{top[0], top[1]};
        }
        return res;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

//return Arrays.copyOf(points, k);

/*
minHeap -> o1 - o2 (default, but need to override if NOT compare int)
maxHeap -> Override:
           1. by Override Comparator
           2. by Lambda function (o1, o2) -> o2 - o1
           3. by use reverseOrder(): new PriorityQueue<>(Collections.reverseOrder());
    Implementation 1: Override Comparator
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
         @Override
         public int compare(int[] o1, int[] o2) {
             return distance(o2) - distance(o1);
         }
    });
    Implementation 2: use Lambda function

    Sol A: calculate distance in lambda function

    PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> o2[2] - o1[2]);
    for (int i = 0; i < points.length; i++) {
        int[] cur = points[i];
        pq.offer(new int[]{cur[0], cur[1], distance(cur)});
        if (pq.size() > k) pq.poll();
    }
    Sol B: store int[x, y, distance] in Heap, only need to calculation distance once

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> distance(o2) - distance(o1));

    return res:
    WRONG: res[i][0] = pq.poll()[0];
           res[i][1] = pq.poll()[1];
    Reason: poll = peek + remove, access to different element

     sol 1:
     int[][] res = new int[k][2];
     for (int i = 0; i < k; i++) {
         int[] top = pq.poll();
         res[i][0] = top[0];
         res[i][1] = top[1];
     }

    sol 2:
    int[][] res = new int[k][];
    for (int i = 0; i < k; i++) {
        int[] top = pq.poll();
        res[i] = new int[]{top[0], top[1]};
    }

}

 */
