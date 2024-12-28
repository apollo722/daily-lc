/*
https://leetcode.com/problems/design-tic-tac-toe/

只需要检查每一步之后有没有人胜利，即已经得到了n分即可
需要对每一行，列，和两个对角线进行统计
用一个2n+2的数组记录n行，n列，以及两个对角线
每一步看是哪个player在哪得分，之后检查对应位置是否已经有n分即可

Time: O(1)
Space: O(n)
*/

class TicTacToe {
    int n;
    int[] m;
    public TicTacToe(int n) {
        this.n = n;
        this.m = new int[2 * n + 2];
    }
    
    public int move(int row, int col, int player) {
        int score = player == 1 ? 1 : -1;
        m[row] += score;
        if (Math.abs(m[row]) == n) return player;
        m[n + col] += score;
        if (Math.abs(m[n + col]) == n) return player;
        if (row == col) {
            m[2 * n] += score;
            if (Math.abs(m[2 * n]) == n) return player;
        }
        if (row + col == n - 1) {
            m[2 * n + 1] += score;
            if (Math.abs(m[2 * n + 1]) == n) return player;
        }
        return 0;
    }
}