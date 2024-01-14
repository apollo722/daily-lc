/*
https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

标准优化sliding window
分别检查T和F即可，而可以将检查两项合并进one pass

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length(), l = 0, r = 0, cntT = 0, cntF = 0, res = 0;
        while (r < n) {
            char c = answerKey.charAt(r);
            if (c == 'F') cntF++;
            else cntT++;
            if (Math.min(cntT, cntF) > k) {
                if (answerKey.charAt(l++) == 'F') cntF--;
                else cntT--;
            }
            res = Math.max(r - l + 1, res);
            r++;
        }
        return res;
    }
}