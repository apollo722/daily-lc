/*
https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

首先要求出preSum，这样取每一个sub matrix的和就可以是O(1)
之后就和subarray sum一样，通过map存储当前curSum，之后找途中是否有target
只是要思考如何把2D问题转化成1D问题
因为一定要遍历所有的sub matrix，可以先固定row之后扫描col
也就是扫描所有在[r1,r2]的行，之后再扫描所有的col，之后就和subarray sum一样利用map统计结果

Time: O(m^2 n)
Space: O(mn)
*/

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = 0, curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r1 = 1; r1 <= m; r1++) {
            for (int r2 = r1; r2 <= m; r2++) {
                map.clear();
                for (int c = 1; c <= n; c++) {
                    curSum = preSum[r2][c] - preSum[r1 - 1][c];
                    if (curSum == target) res++;
                    res += map.getOrDefault(curSum - target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return res;
    }
}