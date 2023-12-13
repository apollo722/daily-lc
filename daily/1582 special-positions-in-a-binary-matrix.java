/*
https://leetcode.com/problems/special-positions-in-a-binary-matrix/

统计每行/列拥有1的个数，cell为1的行与列都只包含1个1即res++

Time: O(mn)
Space: O(m + n)
*/

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] r = new int[m], c = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) res++;
            }
        }
        return res;
    }
}