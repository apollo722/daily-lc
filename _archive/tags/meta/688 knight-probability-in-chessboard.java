/*
https://leetcode.com/problems/knight-probability-in-chessboard/

用二维数组存储每一个可能的位置，扫描k次，每一次找到上一个可能的位置，之后加上上次位置的可能性/8
最后把所有的位置的概率加起来即可

Time: O(kn^2)
Space: O(n^2)
*/

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1.0;
        int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        double[][] prevDp = new double[n][n];
        double[][] curDp = new double[n][n];
        prevDp[row][column] = 1.0;
        for (int i = 0; i < k; i++) {
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    curDp[p][q] = 0.0;
                    for (int[] dir : dirs) {
                        int prevX = p - dir[0], prevY = q - dir[1];
                        if (prevX >= 0 && prevX < n && prevY >= 0 && prevY < n) {
                            curDp[p][q] += prevDp[prevX][prevY] / 8.0;
                        }
                    }
                }
            }
            double[][] tmp = prevDp;
            prevDp = curDp;
            curDp = tmp;
        }
        double prob = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prob += prevDp[i][j];
            }
        }
        return prob;
    }
}