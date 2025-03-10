class Solution {
    int MOD = 1000000007;
    public int numWays(String[] words, String target) {
        int wordLen = words[0].length(), tarLen = target.length();
        int[][] dp = new int[wordLen][tarLen];
        for (int i = 0; i < wordLen; i++) Arrays.fill(dp[i], -1);
        int[][] freqMap = new int[wordLen][26];
        for (String word : words) {
            for (int j = 0; j < wordLen; j++) {
                int pos = word.charAt(j) - 'a';
                freqMap[j][pos]++;
            }
        }
        return (int) solve(words, target, 0, 0, dp, freqMap);
    }

    private long solve(String[] words, String target, int wordIdx, int tarIdx, int[][] dp, int[][] freqMap) {
        if (tarIdx == target.length()) return 1;
        if (wordIdx == words[0].length() || words[0].length() - wordIdx < target.length() - tarIdx) return 0;
        if (dp[wordIdx][tarIdx] != -1) return dp[wordIdx][tarIdx];
        long res = 0;
        int curPos = target.charAt(tarIdx) - 'a';
        res += solve(words, target, wordIdx + 1, tarIdx, dp, freqMap);
        res += freqMap[wordIdx][curPos] * solve(words, target, wordIdx + 1, tarIdx + 1, dp, freqMap);
        dp[wordIdx][tarIdx] = (int) (res % MOD);
        return dp[wordIdx][tarIdx];
    }
}


/*
这种题到底要怎么想才能有思路啊……
对于tar中的每个字符，都需要在src中顺序的找一个位置来匹配它。这个位置可能来自于list中任何一个单词。
先从最简单的情况开始想。如果tar的长度比src的长度要长，匹配不了，一定是0。
如果tar长度只有1，那么就要看list中每一个单词的每个位置，总共有多少个跟tar同样的字符。
如果tar长度是2，情况稍微复杂，因为如果src单词比较长的话，并不会知道第一个字符匹配到哪个位置。
一个好的消息是按照题意，排前面的字符只能跟同在src前面的位置匹配。也就是说如果src长度是4，第一个字符匹配了3之后，第二个字符只能匹配4了。
既然不一定在哪个位置开始匹配，那么每个位置就有两个选择：要么匹配tar的这个字符，要么不匹配，留给下面。
如果选择不匹配，那就继续看下一个位置。如果选择匹配，那就计算这个位置所有单词tar[j]字符的频率。
想着想着一个带记忆的递归就出来了。每次处理子问题，分两个可能：匹配跟不匹配。
如果不匹配就继续走。如果匹配了，当前字符的频率就乘以接下来递归的结果，代表有频率那么多的选择。
最后看base情况。如果tar已经匹配完成，返回1。如果src已经没了，或者src剩下的长度不如tar剩下的长度，直接返回0。
记忆的过程就是src的index i以及tar的index j。
*/