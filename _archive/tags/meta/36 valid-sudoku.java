/*
https://leetcode.com/problems/valid-sudoku/

可以利用mask来存储每一行/列/box的状态以节省空间

Time: O(1)
Space: O(1)
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        int[] row = new int[N], col = new int[N], box = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0' - 1;
                int mask = (1 << val);
                if ((row[i] & mask) != 0) return false;
                if ((col[j] & mask) != 0) return false;
                if ((box[i / 3 * 3 + j / 3] & mask) != 0) return false;
                row[i] |= mask;
                col[j] |= mask;
                box[i / 3 * 3 + j / 3] |= mask;
            }
        }
        return true;
    }
}