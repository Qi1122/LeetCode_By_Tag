/*
https://leetcode.com/problems/number-of-islands/
 */
import java.util.*;

public class Island_Number_200 {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if (x < grid.length && y < grid[0].length && x >= 0
                        && y >= 0 && !visited[x][y] && grid[x][y] == '1') {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}
