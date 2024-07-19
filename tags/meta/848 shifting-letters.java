/*
https://leetcode.com/problems/shifting-letters/

反向presum，之后挨个转移即可
注意会超过max int，要即时对26取余数

Time: O(n)
Space: O(n)
*/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int[] preSum = new int[n];
        preSum[n - 1] = shifts[n - 1];
        preSum[n - 1] %= 26;
        for (int i = n - 2; i >= 0; i--) {
            preSum[i] = preSum[i + 1] + shifts[i];
            preSum[i] %= 26;
        }
        // for (int i = 0; i < n; i++) preSum[i] %= 26;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a' + preSum[i];
            if (c >= 26) c -= 26;
            res.append((char) (c + 'a'));
        }
        return res.toString();
    }
}