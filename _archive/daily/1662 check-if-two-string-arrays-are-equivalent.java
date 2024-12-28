/*
https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

两个word ptr两个str ptr直接扫描即可

Time: O(nk)，n为平均单词个数，k为平均单词长度
Space: O(1)
*/

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int m = word1.length, n = word2.length, i = 0, j = 0, p = 0, q = 0;
        while (i < m && j < n) {
            if (word1[i].charAt(p++) != word2[j].charAt(q++)) return false;
            if (p == word1[i].length()) {
                p = 0;
                i++;
            }
            if (q == word2[j].length()) {
                q = 0;
                j++;
            }
        }
        return i == m && j == n;
    }
}