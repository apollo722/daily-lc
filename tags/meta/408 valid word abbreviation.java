/*
https://leetcode.com/problems/valid-word-abbreviation/

每次扫描缩写字符串的一个位置
如果位置是数字，就计算目前为止的offset。如果存在offset为0的情况，直接返回false，因为题目不允许有0
如果位置是字符，首先目标串要前进当前记录的offset，如果已经超过目标串的长度，直接返回false
如果没有超过目标串长度，且当前字符不匹配，也返回false
如果匹配了，继续查看目标串下一位置
最后目标串的下标加上offset应该刚好等于目标串长度

Time: O(n), n is length of abbr
Space: O(1)
*/

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int curNum = 0, m = word.length(), n = abbr.length(), j = 0;
        for (int i = 0; i < n; i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (curNum == 0 && c == '0') return false;
                curNum = curNum * 10 + c - '0';
            }
            else {
                j += curNum;
                if (j >= m) return false;
                if (word.charAt(j) != c) return false;
                j++;
                curNum = 0;
            }
        }
        return j + curNum == m;
    }
}