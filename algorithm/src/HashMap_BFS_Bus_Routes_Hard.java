/*

https://leetcode.com/problems/bus-routes/

hashmap + bfs
1. variables:
  - int totalBus = 0 -> result
  - Deque<Integer> q -> stops waiting to be checked
  - Set<Integer> visitedStop -> alreay checked stops
  - boolean[] visitedBus -> alreay checked buses
  - Map<Integer, List<Integer>> stopToBus ->
  * routes[][]: bus to stop mapping: routes[i]: all stops of bus i

2.algorithm:
 2.1 construct stopToBus map
    key: stop, value: bus List<Integer>
         1     [0]
         2     [0]
         7     [0, 1]
         3     [1]
         6     [1]
 2.2 offer start stop to q
 2.3 expand q -> iterate all current q members
              -> q.poll(): target ? return : (add to visitedStop -> get bus list from map -> go through each bus)
              -> update totalBus after each q iteration

*/
package algorithm.src;

import java.util.*;

public class HashMap_BFS_Bus_Routes_Hard {
    private Map<Integer, List<Integer>> stopToBus = new HashMap<>();
    private Set<Integer> visitedStop = new HashSet<>();
    private Deque<Integer> q = new ArrayDeque<>();
    private int totalBus = 0;

    public int numBusesToDestination(int[][] routes, int source, int target) {
        constructStopToBusMap(routes);
        boolean[] visitedBus = new boolean[routes.length];
        q.offer(source);
        if (bfs(routes, target, visitedBus)) return totalBus;
        return -1;
    }

    private boolean bfs(int[][] routes, int target, boolean[] visitedBus) {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curStop = q.poll();
                if (curStop == target) return true;
                visitedStop.add(curStop);
                List<Integer> buses = stopToBus.get(curStop);
                for (int bus : buses) {
                    if (visitedBus[bus] == true) continue;
                    else {
                        for (int stop : routes[bus]) {
                            if(!visitedStop.contains(stop)) q.offer(stop);
                        }
                        visitedBus[bus] = true;
                    }
                }
            }
            totalBus++;
        }
        return false;
    }

    public void constructStopToBusMap(int[][] routes) {
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int key = routes[i][j];
                stopToBus.put(key, stopToBus.getOrDefault(key, new ArrayList<Integer>()));
                stopToBus.get(key).add(i);
            }
        }
    }
}
