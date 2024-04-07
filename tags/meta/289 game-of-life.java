/*
https://leetcode.com/problems/game-of-life/

因为要in place，又要保证信息不丢失，所以需要在保留信息的同时又能标记想要做的事
所以可以规定：
如果一个cell死了（1->0），如果它原来是1，那么就标记成-1
如果一个cell活了（0->1），如果它原来是0，那么就标记成2
其他情况不用变
那么检查周边的1就变成了检查周边的绝对值

Time: O(n)
Space: O(1)
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    
    private void check(int[][] board, int row, int col) {
        int cnt = 0, cur = board[row][col];
        int m = board.length, n = board[0].length;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue;
                if (i < 0 || j < 0 || i >= m || j >= n) continue;
                if (Math.abs(board[i][j]) == 1) cnt++;
            }
        }
        if (cnt < 2 && cur == 1) board[row][col] = -1;
        else if (cnt == 3 && cur == 0) board[row][col] = 2;
        else if (cnt > 3 && cur == 1) board[row][col] = -1;    
    }
}