/*
https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

贪心的从上到下扫描，每次都将该行与列中更小的值填入当前位置，并将其从原本和中减去
这样行和列一定有一个变为0，变为0的那个意味着这一行或列都已经满足了，那么像另外的方向移动即可

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] res = new int[m][n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            res[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= res[i][j];
            colSum[j] -= res[i][j];
            if (rowSum[i] == 0) i++;
            else j++;
        }
        return res;
    }
}