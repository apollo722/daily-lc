/*
https://leetcode.com/problems/longest-palindrome/

偶数频率的都直接加，奇数的去掉一个再加上
但是最多可以有一个奇数频率的作为中心
所以统计一下奇数频率，如果出现过最后可以加个1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int res = 0, count = 0;
        for (int num : map) {
            if (num % 2 == 0) res += num;
            else {
                res += num - 1;
                count++;
            }
        }
        return count > 0 ? res + 1 : res;
    }
}