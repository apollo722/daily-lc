/*
https://leetcode.com/problems/toeplitz-matrix/

扫描所有元素(i,j)，检查其是否和(i-1,j-1)相等即可

Time: O(mn)
Space: O(1)
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }
}