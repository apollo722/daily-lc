/*
https://leetcode.com/problems/valid-palindrome-iii/

用bottom-up DP 可以space O(n): https://leetcode.com/problems/valid-palindrome-iii/editorial/

Time: O(n2)
Space: O(n2)
*/

class Solution {
    int[][] memo;
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        memo = new int[n + 1][n + 1];
        return check(s, 0, n - 1) <= k;
    }

    private int check(String s, int l, int r) {
        if (l >= r) return 0;
        if (memo[l][r] != 0) return memo[l][r];
        if (s.charAt(l) == s.charAt(r)) {
            memo[l][r] = check(s, l + 1, r - 1);
            return memo[l][r];
        } else {
            memo[l][r] = 1 + Math.min(check(s, l, r - 1), check(s, l + 1, r));
            return memo[l][r];
        }
    }
}