/*
https://leetcode.com/problems/set-matrix-zeroes/

in place的利用输入的第一行和第一列来存储是否要将某行列置0
其中(0,0)的位置只能保存行或列的信息，所以需要额外的变量来存储信息
置0的时候要注意先从第二行和列开始，注意防止第一行和第一列的置0信息影响后面的置0

Time: O(mn)
Space: O(1)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean setFirstCol = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) setFirstCol = true;
                    else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                    
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }  
        if (setFirstCol) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}