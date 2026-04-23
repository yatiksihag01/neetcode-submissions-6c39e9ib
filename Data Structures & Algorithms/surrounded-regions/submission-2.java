class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean isBorder = (r == 0 || r == rows - 1 || c == 0 || c == cols - 1);
                if (isBorder && board[r][c] == 'O') {
                    captureBorderConnected(board, r, c);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    private void captureBorderConnected(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        captureBorderConnected(board, r + 1, c);
        captureBorderConnected(board, r - 1, c);
        captureBorderConnected(board, r, c + 1);
        captureBorderConnected(board, r, c - 1);
    }
}
