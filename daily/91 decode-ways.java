/*
https://leetcode.com/problems/decode-ways/

下一个状态取决于前面的状态，即用dp来存储每一个位置可能组成结果的数量
首先要排除leading 0的情况，直接返回0
之后初始化数组，每个位置都置为1，这是因为除了那些非法情况，否则每个位置至少有1中解法
扫描过程中要记录前一个位置的字符，因为前一位置的值会影响当前可能产生的组合

逐个位置扫描，分如下情况：
1. 非法情况：当前字符是0，而前一个字符是0或者大于2，则一定非法，因为不可能有00或者30的情况，当前位置为0前面只能为1或2
2. 前面是1或2：
2.a 当前是0，则前面和当前一定要组合成成10或者20，即当前的组合数等于再前面的组合数，即dp[i]=dp[i-2]
2.b 前面是1，那么当前字符可以自己成为字母，也可以和前面的1组成字母，即dp[i]=dp[i-1]+dp[i-2]
2.c 前面是2
2.c.i 那么当前数字只有是[1,6]时才能既可以自己成为字母，又和前面的2组成字母，即dp[i]=dp[i-1]+dp[i-2]
2.c.ii 否则如果大于6，就只能自己组成字母了，即dp[i]=dp[i-1]
3. 前面是其它，包括0，那么当前字符只能自己组成字母，即dp[i]=dp[i-1]

以上的情况可以归纳成以下code所示的三种情况：非法，能和前面组合，只能自己成为字母

Time: O(n)
Space: O(n)
*/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int prev = s.charAt(0) - '0';
        for (int i = 2; i <= n; i++) {
            int cur = s.charAt(i - 1) - '0';
            if ((prev == 0 || prev > 2) && cur == 0) return 0;  // 非法情况
            else if (prev == 1 || (prev == 2 && cur <= 6)) {  // 前面可以和当前字符组合的情况
                if (cur == 0) dp[i] = dp[i - 2];  // 如果当前是0，只能和前面组合
                else dp[i] = dp[i - 1] + dp[i - 2];  // 不是0，那么既可以组合，也可以自己成字母
            } else dp[i] = dp[i - 1];  // 不能组合，只能自己成为字母
            prev = cur;
        }
        return dp[n];
    }
}