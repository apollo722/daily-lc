class Solution {
    
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int r) {
        for (int i = r; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (isValid(board, i, j) && solve(board, i)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c) {
        char tar = board[r][c];
        for (int i = 0; i < 9; i++) {
            if (i == c) continue;
            if (board[r][i] == tar) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i == r) continue;
            if (board[i][c] == tar) return false;
        }
        int rowStart = r / 3, colStart = c / 3;
        for (int i = rowStart * 3; i < rowStart * 3 + 3; i++) {
            for (int j = colStart * 3; j < colStart * 3 + 3; j++) {
                if (r == i && c == j) continue;
                if (tar == board[i][j]) return false;
            }
        }
        return true;
    }
}