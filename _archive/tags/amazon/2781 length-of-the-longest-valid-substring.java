/*
https://leetcode.com/problems/length-of-the-longest-valid-substring/

先用一个set存下所有的禁忌词，并找到最长的长度
超过最长的禁忌词长度的substr一定包括禁忌词，所以最长也就扫到最长的长度
从右向左检查，这是因为如果[i,j]包含禁忌词，那么[i-1,j]一定也包含禁忌词
所以每一轮查找的最右边边界就被j限制住了
所以两层循环分别从长度1到禁忌词的最长长度
如果找到了禁忌词，那么最右的位置就是当前j的位置

Time: O(nlen)，len为禁忌词最长长度
Space: O(m)，m为禁忌词个数
*/

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>();
        int len = 0;
        for (String s : forbidden) {
            len = Math.max(len, s.length());
            set.add(s);
        }
        int n = word.length(), res = 0;
        for (int i = n - 1, curRight = n; i >= 0 && curRight > res; i--) {
            StringBuilder curStr = new StringBuilder();
            for (int j = i; j < curRight && j - i < len; j++) {
                curStr.append(word.charAt(j));
                if (set.contains(curStr.toString())) {
                    curRight = j;
                    break;
                }
            }
            res = Math.max(res, curRight - i);
        }
        return res;
    }
}