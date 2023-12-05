package algorithm.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_SprialMatrix_54 {

    List<Integer> list = new ArrayList<>();
    int row = 0;
    int col = 0;

    public static void main(String[] args) {
        Array_SprialMatrix_54 solution = new Array_SprialMatrix_54();
        int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
        solution.sprialMatrix(data);
    }

    public List<Integer> sprialMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return List.of();
        }

        row = matrix.length;
        if (row == 1) {
            return Arrays.stream(matrix[0]).boxed().toList();
        }

        col = matrix[0].length;
        int r = 0;
        int c = 0;
        while(getDirection(r, c, matrix) != null) {
            String direction = getDirection(r, c, matrix);

            switch(direction) {
                case "RIGHT":
                    while (c < col && !list.contains(matrix[r][c])) {
                        list.add(matrix[r][c++]);
                    }
                    break;

                case "DOWN":
                    while (r < row && !list.contains(matrix[r][c])) {
                        list.add(matrix[r++][c]);
                    }
                    break;

                case "LEFT":
                    while (c >= 0 && !list.contains(matrix[r][c])) {
                        list.add(matrix[r][c--]);
                    }
                    break;

                case "UP":
                    while (r >= 0 && !list.contains(matrix[r][c])) {
                        list.add(matrix[r--][c]);
                    }
                    break;
            }
        }
        return list;
    }

    private String getDirection(int r, int c, int[][] matrix) {
        if (c + 1 < col && !list.contains(matrix[r][c + 1])) {
            return "RIGHT";
        }

        if (r + 1 < row && !list.contains(matrix[r + 1][c])) {
            return "DOWN";
        }

        if (c - 1 >= 0 && !list.contains(matrix[r][c - 1])) {
            return "LEFT";
        }

        if (r - 1 >= 0 && !list.contains(matrix[r - 1][c])) {
            return "UP";
        }

        return null;
    }
}
