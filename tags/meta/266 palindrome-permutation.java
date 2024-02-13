/*
https://leetcode.com/problems/palindrome-permutation/

统计字符频率，只要奇数频率的次数小于或等于1，就能形成回文串

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] m = new int[26];
        for (char c : s.toCharArray()) {
            m[c - 'a']++;
        }
        int cnt = 0;
        for (int num : m) {
            if (num % 2 == 1) cnt++;
        }
        return cnt <= 1;
    }
}