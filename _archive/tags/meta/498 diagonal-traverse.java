/*
https://leetcode.com/problems/diagonal-traverse/

模拟扫描

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0;
        boolean goingUp = true;
        int idx = 0;
        while (idx < res.length) {
            res[idx++] = mat[i][j];
            if (goingUp) {
                if (i == 0 || j == n - 1) {
                    if (j != n - 1) j++;
                    else i++;
                    goingUp = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1 || j == 0) {
                    if (i != m - 1) i++;
                    else j++;
                    goingUp = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}