/*
https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/

先把字符的频率都统计出来
遍历这些频率，把每个频率当作是删除后最小的频率来求需要删除多少
固定最小频率之后，任何小于当前最小频率的字符都要被删除
且任何大于最小频率的频率要被删除到min+k的程度
最后找到最小的删除数即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumDeletions(String word, int k) {
        int res = Integer.MAX_VALUE;
        int[] m = new int[26];
        for (char c : word.toCharArray()) {
            m[c - 'a']++;
        }
        for (int min : m) {
            if (min == 0) continue;
            int cur = 0;
            for (int x : m) {
                if (x == 0) continue;
                cur += (x < min) ? x : Math.max(0, x - (min + k));
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}