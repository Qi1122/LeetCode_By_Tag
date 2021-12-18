/*
https://leetcode.com/problems/the-maze/
 */
import java.util.*;

public class Maze_490 {
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return bfs(maze, start, destination, visited);
    }

    private boolean bfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (Arrays.equals(cur, destination)) return true;
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                while (x < maze.length && y < maze[0].length
                        && x >= 0 && y >= 0 && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
