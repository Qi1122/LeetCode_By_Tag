/*
https://leetcode.com/problems/max-area-of-island/
bfs only do bfs, update area in function
 */

import java.util.*;

public class Max_Area_Island_695 {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(bfs(grid, i, j, visited, maxArea), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col, boolean[][] visited, int maxArea) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        int area = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < grid.length && y < grid[0].length && x >= 0
                        && y >= 0 && grid[x][y] == 1 && !visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                    area++;
                }
            }
        }
        return area;
    }
}
