class Solution {
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0);
        return res;
    }

    private void backtrack(int cur) {
        if (cur == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));  
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            board[cur][i] = 'Q';
            if (isValid(cur, i)) {
                backtrack(cur + 1);
            }
            board[cur][i] = '.';
        }
    }

    private boolean isValid(int cur, int col) {
        for (int i = 0; i < cur; i++) {
            if (board[i][col] == 'Q') return false;
        }
        int p = cur, q = col;
        while (--p >= 0 && --q >= 0) {
            if (board[p][q] == 'Q') return false;
        }
        p = cur;
        q = col;
        while (--p >= 0 && ++q < board.length) {
            if (board[p][q] == 'Q') return false;
        }
        return true;
    }
}