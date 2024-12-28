/*
https://leetcode.com/problems/determine-if-string-halves-are-alike/

分别统计输入两半的元音即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean halvesAreAlike(String s) {
        int l = 0, r = s.length() - 1, cntL = 0, cntR = 0;
        String vowels = "aeiouAEIOU";
        while (l < r) {
            if (vowels.indexOf(s.charAt(l++)) != -1) cntL++;
            if (vowels.indexOf(s.charAt(r--)) != -1) cntR++;
        }
        return cntL == cntR;
    }
}