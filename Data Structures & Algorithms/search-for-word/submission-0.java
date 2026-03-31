class Solution {
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) return true;

        if (row < 0 || col < 0 ||
            row >= ROWS || col >= COLS ||
            board[row][col] != word.charAt(index)
        ) return false;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean result = backtrack(board, word, row - 1, col, index + 1) ||
                         backtrack(board, word, row + 1, col, index + 1) ||
                         backtrack(board, word, row, col - 1, index + 1) ||
                         backtrack(board, word, row, col + 1, index + 1);

        board[row][col] = temp;

        return result;
    }
}
