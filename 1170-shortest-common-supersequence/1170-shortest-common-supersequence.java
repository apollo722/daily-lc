class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) sb.append(str1.charAt((i--) - 1));
        while (j > 0) sb.append(str2.charAt((j--) - 1));
        return sb.reverse().toString();
    }
}


/*
    c a b
  0 0 0 0
a 0 0 1 1
b 0 0 1 2 
a 0 0 1 2
c 0 1 1 2 

两种思路：
1. 利用1143题先构建最长公共序列，这样所有不在公共子序列里的字符直接加上去就行，最终结果也一定是最短的。
那么就先用dp来找到最长公共序列的长度，每一个位置应该是多长。
之后反向的构建出来。构建方式和求解长度的方式一样。
即如果遇到了相同的字符，那么他一定是最长公共序列里的，直接把它放到结果中。
如果是不同的字符，那么要看当前的长度来自哪里，是谁贡献的。
比如如果dp[i][j]==dp[i-1][j]，那么说明上一步是取了同样的j，所以要把对应i位置的字符加进去。
因为dp[i-1][j]的意思是str1[i-1]与str2[j]二者最长公共子序列，所以i不在结果中，故逆向构建的时候要加回去。
这样剩余如果任意字符串还有余量的字符，就直接append到前面即可。

2. 先找到最短公共序列的长度，之后再反向构建，思路和1差不多。
dp[i][j]代表str1[i]与str2[j]最短的公共序列。如果str1[i]==str2[j]，那么这个字符肯定要加上的，因为二者共用了。
所以dp[i][j]=dp[i-1][j-1]+1。
如果字符不同，那要看把哪个字符串的字符挂上去。挂哪个要从前一个状态找最短的，即min(dp[i-1][j], dp[i][j-1])+1。
返回来构建的时候同1，如果dp[i][j]==dp[i-1][j]+1，说明上一步取了同样的j没有取i处字符，构建就要加回i处字符。
*/