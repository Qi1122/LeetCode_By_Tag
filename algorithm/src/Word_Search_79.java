package algorithm.src;

public class Word_Search_79 {
    private static final int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)  {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        if (rows * cols < word.length()) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int wordIndex) {
        if (wordIndex == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || board[x][y] != word.charAt(wordIndex)) return false;
        board[x][y] = '#';
        for (int[] dir : dirs) {
            if (dfs(board, word, x + dir[0], y + dir[1], wordIndex + 1)) {
                board[x][y] = word.charAt(wordIndex);
                return true;
            }
        }
        board[x][y] = word.charAt(wordIndex);
        return false;
    }
}
