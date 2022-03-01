/*
N -> vertices
M -> edges
w -> edge weight
find maxWeight from vertex A to vertex B -> find min

1. a. use hashmap to store data:
    key: vertex
    value: connected vertices -> List<Pair>
   b. use set to track visited vertex
   c. use maxHeap to decide next visit point until reach end
2. bfs: pop out the max value from heap
        -> (if end) & (ifVisited ? continue : set visited)
 */
package algorithm.src;
import java.util.*;

public class BFS_PQ_XJWHW {
    private Map<Integer, List<Pair>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private int res = Integer.MAX_VALUE;

    private int findMaxWeight(int start, int end) {
        bfs(start, end);
        return res;
    }

    private void bfs(int start, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        pq.offer(new Pair(start, res));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int vertex = cur.key;
            int weight = cur.val;
            //System.out.println(vertex + " " + weight);
            if (vertex == end) {
                res = Math.min(res, weight);
                return;
            }
            if (visited.contains(vertex)) {
                continue;
            } else {
                visited.add(vertex);
                res = Math.min(res, weight);
                for (Pair neighbor : map.get(vertex)) {
                    pq.offer(neighbor);
                    //pq.offer(new Pair(neighbor.key, Math.min(weight, neighbor.val)));
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS_PQ_XJWHW sol = new BFS_PQ_XJWHW();
        sol.constructMap();
        int maxWeight = sol.findMaxWeight(0, 6);
        System.out.println(maxWeight);
    }

    private void constructMap() {
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4, new ArrayList<>());
        map.put(5, new ArrayList<>());
        map.put(6, new ArrayList<>());
        map.put(7, new ArrayList<>());
        map.get(0).add(new Pair(2,7));
        map.get(0).add(new Pair(1,6));
        map.get(1).add(new Pair(0,6));
        map.get(1).add(new Pair(3,5));
        map.get(2).add(new Pair(0,7));
        map.get(2).add(new Pair(4,10));
        map.get(2).add(new Pair(6,3));
        map.get(2).add(new Pair(5,8));
        map.get(3).add(new Pair(1,5));
        map.get(3).add(new Pair(4,9));
        map.get(4).add(new Pair(3,9));
        map.get(4).add(new Pair(2,10));
        map.get(4).add(new Pair(5,7));
        map.get(4).add(new Pair(6,4));
        map.get(5).add(new Pair(2,8));
        map.get(5).add(new Pair(7,6));
        map.get(6).add(new Pair(2,5));
        map.get(6).add(new Pair(4,4));
        map.get(6).add(new Pair(7,5));
        map.get(7).add(new Pair(5,6));
        map.get(7).add(new Pair(6,5));

    }

    private class Pair {
        //key: vertex, val: weight
        private int key, val;
        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
