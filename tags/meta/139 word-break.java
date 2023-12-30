/*
https://leetcode.com/problems/word-break/

扫描wordDict中的每一个单词，看当前str是否以它起始
如果是，则继续检查接下来的单词，如果最后有一种情况返回true，则整体返回true
在这过程中会有很多重复计算的情况，则可以根据每个idx的位置存储余下的长度是否已被计算过

Time: O(mnk)，m为wordDict长度，k为word avg长度
Space: O(n)
*/

class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length() + 1];
        return check(s, 0, wordDict);
    }

    private boolean check(String s, int idx, List<String> wordDict) {
        if (idx >= s.length()) return true;
        if (memo[idx] != null) return memo[idx];
        for (String w : wordDict) {
            if (s.startsWith(w, idx)) {
                if (check(s, idx + w.length(), wordDict)) {
                    memo[idx] = true;
                    return true;
                }
            }
        }
        memo[idx] = false;
        return false;
    }
}