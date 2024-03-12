/*
https://leetcode.com/problems/merge-strings-alternately/

交替append到结果，就像merge list一样

Time: O(m+n)
Space: O(1)
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        boolean flag = true;
        StringBuilder res = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if (flag) {
                res.append(word1.charAt(i++));
                flag = !flag;
            } else {
                res.append(word2.charAt(j++));
                flag = !flag;
            }
        }
        while (i < word1.length()) res.append(word1.charAt(i++));
        while (j < word2.length()) res.append(word2.charAt(j++));
        return res.toString();
    }
}