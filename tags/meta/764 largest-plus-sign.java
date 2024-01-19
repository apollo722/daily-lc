/*
https://leetcode.com/problems/largest-plus-sign/

利用dp分别求解每一个元素四个方向1最多的个数
即每个方向比如010110，那么1的个数即010120，即如果之前是1，那么就是cnt+1，否则置0
最后对每个元素取四个方向最小值即可

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        HashSet<Integer> set = new HashSet<>();
        for (int[] mine : mines) {
            set.add(mine[0] * n + mine[1]);
        }
        int[][] dp = new int[n][n];
        int cnt = 0, res = 0;
        for (int r = 0; r < n; r++) {
            cnt = 0;
            for (int c = 0; c < n; c++) {
                cnt = set.contains(r * n + c) ? 0 : cnt + 1;
                dp[r][c] = cnt;
            }
            cnt = 0;
            for (int c = n - 1; c >= 0; c--) {
                cnt = set.contains(r * n + c) ? 0 : cnt + 1;
                dp[r][c] = Math.min(cnt, dp[r][c]);
            }
        }

        for (int c = 0; c < n; c++) {
            cnt = 0;
            for (int r = 0; r < n; r++) {
                cnt = set.contains(r * n + c) ? 0 : cnt + 1;
                dp[r][c] = Math.min(cnt, dp[r][c]);
            }
            cnt = 0;
            for (int r = n - 1; r >= 0; r--) {
                cnt = set.contains(r * n + c) ? 0 : cnt + 1;
                dp[r][c] = Math.min(cnt, dp[r][c]);
                res = Math.max(res, dp[r][c]);
            }
        }
        return res;
    }
}