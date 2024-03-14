/*
https://leetcode.com/problems/rotate-image/

剥洋葱，从外圈剥到里面
行的loop只需要走一半，列的loop从行开始（即对角线）走到对向对角线（即n-i）
用tmp变量逐个交换即可
记不住的话可以简单总结几个找规律
假设n为5，前两轮交换的分别为
00=40
40=44
44=04
04=00

01=30
30=43
43=14
14=01
即能观察到，本轮不变的0处即为i，n-1处为n-i，变大的即为j，变小的即为n-j，

Time: O(n^2)
Space: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = matrix.length - 1;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = tmp;
            }
        }
    }
}