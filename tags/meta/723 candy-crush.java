/*
https://leetcode.com/problems/candy-crush/

分为两步：标记和drop
行列分别找到连续三个或更多相同的数字，并标记
标记整个棋盘后，逐列drop被标记的cell
为了节省空间，利用原棋盘把找到的cell标记为负数
drop时，逐列检查，负数的就顺势落下

Time: O(m2n2)
Space: O(1)
*/

class Solution {
    int m, n;
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        while (find(board)) {
            drop(board);
        }
        return board;
    }

    private boolean find(int[][] board) {
        boolean res = false;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = board[i][j];
                if (val == 0) continue;
                if (Math.abs(board[i - 1][j]) == Math.abs(val) && Math.abs(val) == Math.abs(board[i + 1][j])) {
                    board[i][j] = -Math.abs(val);
                    board[i - 1][j] = -Math.abs(val);
                    board[i + 1][j] = -Math.abs(val);
                    res = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                int val = board[i][j];
                if (val == 0) continue;
                if (Math.abs(board[i][j - 1]) == Math.abs(val) && Math.abs(val) == Math.abs(board[i][j + 1])) {
                    board[i][j] = -Math.abs(val);
                    board[i][j + 1] = -Math.abs(val);
                    board[i][j - 1] = -Math.abs(val);
                    res = true;
                }
            }
        }
        
        return res;
    }

    private void drop(int[][] board) {
        for (int j = 0; j < n; j++) {
            int i = m - 1, cur = m - 1;
            while (i >= 0) {
                if (board[i][j] < 0) i--;
                else {
                    board[cur][j] = board[i][j];
                    cur--;
                    i--;
                }
            } 
            while (cur >= 0) board[cur--][j] = 0;
        }
    }
}