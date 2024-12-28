/*
https://leetcode.com/problems/custom-sort-string/

统计目标串每个字符的个数
之后按照order串的顺序逐个放到结果
最后再把剩余的字符放入结果

Time: O(m + n)
Space: O(1)
*/

class Solution {
    public String customSortString(String order, String s) {
        int[] m = new int[26];
        for (char c : s.toCharArray()) {
            m[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (m[c - 'a']-- > 0) res.append(c);
        }
        for (int i = 0; i < 26; i++) {
            while (m[i]-- > 0) res.append((char) (i + 'a'));
        }
        return res.toString();
    }
}