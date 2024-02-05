/*
https://leetcode.com/problems/n-queens/

backtracking模板

Time: O(n!)
Space: O(n^2)
*/

class Solution {
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');
        backtrack(0);
        return res;
    }

    private void backtrack(int idx) {
        if (idx == n) {
            List<String> l = new ArrayList<>();
            for (char[] r : board) {
                String row = new String(r);
                l.add(row);
            }
            res.add(l);
            return;
        }
        for (int j = 0; j < n; j++) {
            board[idx][j] = 'Q';
            if (isValid(idx, j)) {
                backtrack(idx + 1);
            }
            board[idx][j] = '.';
        }
    }

    private boolean isValid(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') return false;
        }
        int i = r, j = c;
        while (--i >= 0 && ++j < n) {
            if (board[i][j] == 'Q') return false;
        }
        i = r;
        j = c;
        while (--i >= 0 && --j >= 0) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}