/*
https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/

统计出现频率，对所有频率执行C52的选择，最后再把长度加到结果即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public long numberOfSubstrings(String s) {
        int[] m = new int[26];
        for (char c : s.toCharArray()) m[c - 'a']++;
        long res = 0;
        for (long num : m) {
            if (num > 1) {
                long tmp = num * (num - 1);
                res += tmp / 2;
            }
        }
        return (long)(res + s.length());
    }
}