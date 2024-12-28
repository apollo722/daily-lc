/*
https://leetcode.com/problems/longest-palindromic-substring/

检查以每一个index和每一个index空隙为中心能否构成回文串，即检查(i, i)与(i, i + 1)

Time: O(n)
Space: O(1)
*/

class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 1, resStart = 0;
        int[] arr = {0, 0};
        for (int i = 0; i < s.length() - 1; i++) {
            arr[0] = i;
            arr[1] = i;
            check(s, arr);
            if (arr[1] - arr[0] + 1 > maxLen) {
                maxLen = arr[1] - arr[0] + 1;
                resStart = arr[0];
            }
            arr[0] = i;
            arr[1] = i + 1;
            check(s, arr);
            if (arr[1] - arr[0] + 1 > maxLen) {
                maxLen = arr[1] - arr[0] + 1;
                resStart = arr[0];
            }
        }
        return s.substring(resStart, resStart + maxLen);
    }

    private void check(String s, int[] arr) {
        while (arr[0] >= 0 && arr[1] < s.length() && s.charAt(arr[0]) == s.charAt(arr[1])) {
            arr[0]--;
            arr[1]++;
        }
        arr[0]++;
        arr[1]--;
    }
}