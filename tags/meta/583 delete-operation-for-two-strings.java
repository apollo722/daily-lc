/*
https://leetcode.com/problems/delete-operation-for-two-strings/

通过dp来检查两个str的每一个位置，如果当前位置字符相等，此处最大公共str长度为[i - 1][j - 1] + 1
每个位置公共str长度都不会少于[i - 1]和[j - 1]
二维dp可以降为一维

  e a t
s 0 0 0
e 1 1 1
a 1 2 2

Time: O(mn)
Space: O(n)
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int res = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] curDp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    int cur = dp[j - 1] + 1;
                    curDp[j] = Math.max(Math.max(cur, dp[j]), curDp[j - 1]);
                } else curDp[j] = Math.max(dp[j], curDp[j - 1]);
            }
            dp = curDp;
        }
        return m + n - 2 * dp[n];
    }
}