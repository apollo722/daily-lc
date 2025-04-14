/*
backtrack模板题，关键是如何追踪什么是合法的。
按照行来，每一行必须要放一个，行肯定不会互相冲突。
所以需要追踪的是目前列以及两个对角线的情况。
利用三个boolean数组来追踪目前的列以及对角线元素情况。
对于对角线，左上到右下用 行-列 即可。右上到左下用 行+列 即可。
所以对于每一行，扫描所有列的时候进行backtrack，把当前的列以及对角线放入boolean数组。
如果最终扫描完了所有行，即是合法答案，返回1。否则返回0。

Time: O(N!)
Space: O(N)
*/


class Solution {
    int size;
    int res = 0;
    public int totalNQueens(int n) {
        this.size = n;
        boolean[] cols = new boolean[n], dia = new boolean[2 * n], revDia = new boolean[2 * n];
        backtrack(0, cols, dia, revDia);
        return res;
    }

    private void backtrack(int r, boolean[] cols, boolean[] dia, boolean[] revDia) {
        if (r == size) {
            res++;
            return ;
        }
        for (int c = 0; c < size; c++) {
            int curDia = r - c + size, revCurDia = r + c;
            if (cols[c] || dia[curDia] || revDia[revCurDia]) continue;
            cols[c] = true;
            dia[curDia] = true;
            revDia[revCurDia] = true;
            backtrack(r + 1, cols, dia, revDia);
            cols[c] = false;
            dia[curDia] = false;
            revDia[revCurDia] = false;
        }
    }
}