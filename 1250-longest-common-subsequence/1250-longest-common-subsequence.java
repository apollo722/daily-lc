class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        int m = text1.length(), n = text2. length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
        */

        int m = text1.length(), n = text2. length();
        int[] prev = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + 1;
                } else {
                    cur[j] = Math.max(cur[j - 1], prev[j]);
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}


/*
经典字符串dp题。
    a c e
  0 0 0 0
a 0 1 1 1
b 0 1 1 1 
c 0 1 2 2
d 0 1 2 2 
e 0 1 2 3
设dp[i][j]为str1[i]与str2[j]最长公共序列，要找的是它和更小问题的关系。
已知前一状态的所有结果，即dp[i-1][j], dp[i][j-1], dp[i-1][j-1]。
如果str1[i]==str2[j]时，即遇到了一个公共字符，这个字符肯定要在结果里，因为要找最长嘛。
所以是dp[i-1][j-1] + 1。
如果末尾字符不一致，证明不一致的两个字符肯定不属于最大公共序列，所以找前一状态的最大值即可。

二维dp结束后发现当前状态只取决于前一行，所以只需要一个数组就可以了。优化一下space进行维度压缩即可。

本题可以扩展至1092，即反向的找到该序列。见1092。
*/