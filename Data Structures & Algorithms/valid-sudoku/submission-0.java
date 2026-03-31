class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> squares = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            squares.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                Character charNum = board[i][j];
                if (
                    rows.get(i).contains(charNum) || 
                    cols.get(j).contains(charNum) ||
                    squares.get((i / 3) * 3 + j / 3).contains(charNum)
                ) return false;
                else {
                    rows.get(i).add(charNum);
                    cols.get(j).add(charNum);
                    squares.get((i / 3) * 3 + j / 3).add(charNum);
                }
            }
        }
        return true;
    }
}
