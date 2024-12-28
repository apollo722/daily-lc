/*
https://leetcode.com/problems/sudoku-solver/

backtracking模板

Time: O(9! ^ 9)
Space: O(1)
*/

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (valid(board, i, j, k) && backtrack(board, i, j)) {
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

    private boolean valid(char[][] board, int row, int col, char t) {
        for (int i = 0; i < 9; i++) {
            if (i == col) continue;
            if (board[row][i] == t) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (board[i][col] == t) return false;
        }
        int x = row / 3, y = col / 3;
        for (int i = x * 3; i < x * 3 + 3; i++) {
            for (int j = y * 3; j < y * 3 + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] == t) return false;
            }
        }
        return true;
    }
}