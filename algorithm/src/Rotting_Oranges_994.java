/*
https://leetcode.com/problems/rotting-oranges/
1. scan grid, if cell == 2 -> bfs -> update minutes
note: update all nei for 1 min
2. scan grid again -> cell == 1 -> return -1
*/
import java.util.*:

public class Rotting_Oranges_994 {

    private int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int minutes = 0;
        minutes = bfs(grid, visited);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        if (minutes == -1) return 0;
        return minutes;
    }

    private int bfs(int[][] grid, boolean[][] visited) {
        int minutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            // level by level
            int size = q.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && !visited[x][y] && grid[x][y] == 1) {
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return minutes - 1;
    }
}
