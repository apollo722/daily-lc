class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean checkFirst = (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)));
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (checkFirst && dp[i + 1][j]);
                } else {
                    dp[i][j] = checkFirst && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}


/*
public boolean isMatch(String s, String p) {
    if (p.isEmpty()) return s.isEmpty();
    boolean checkFirst = !s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
    if (p.length() >= 2 && p.charAt(1) == '*') {
        return isMatch(s, p.substring(2)) || (checkFirst && isMatch(s.substring(1), p));
    } else {
        return checkFirst && isMatch(s.substring(1), p.substring(1));
    }
}
如果pattern里面没有*，那么题目就是直白的递归，即先看第一个字符是否可以match，之后再递归检查s[1:]与p[1:]。
如果考虑*，当pattern此刻检查的位置不是*时，和没有*的时候一样。
有*号的时候，要么匹配一个当前的si，要么就当*没出现。因为*一定和前面的字符成对出现，所以对于p要同时看两个位置。
这样递归就好写了：
先检查p是不是空，如果是空，根据s的情况返回。
否则，先查第一个位置。注意这时候s不能是空。第一个位置要么匹配要么p是.。
之后看*的情况。如果p这时候长度至少是2，并且第二个位置是*，那么要么这两个位置就当没存在，即匹配0；要么匹配了当前s的字符。
如果p不满足有*的条件，就像没有*一样处理。

递归写好之后可以同理的转化成bottom-up的dp。
其中dp[i][j]代表s[i:]与p[j:]的匹配情况。
base情况是s与p都为空的情况，这时候是true。
之后逆向开始匹配。逆向是因为*要求前面一定要有字符，所以反向匹配更符合逻辑。
先看i与j处字符的匹配情况。之后如果p有存在*的情况，即j+1<p.length() && p[j+1]==*，那么dp[i][j]既可能是dp[i][j+2]，也可能是dp[i+1][j]。
不存在*时dp[i][j] = dp[i+1][j+1] && firstMatch。
写起来和递归一样，但复杂度相应的由于cache降低。因为计算dp[i][j]的时候i与j之后的情况已经算出来了，所以cache达到了加速目的。

一些细节：
j从p.length()-1开始，是因为要随时计算j+1位*的情况。
而i从s.length()开始，是因为要考虑s是空字符串的情况。相对的，p是空的情况在一开始就检查了。
*/