/*
https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

分别找到两个不同的位置
如果有超过两个不同的位置，直接返回false，或者只有一个不同的位置，也返回false
之后看各自的位置是否是交换后的值即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int first = -1, second = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else return false;
            }
        }
        if (second == -1) return false;
        return s1.charAt(first) == s2.charAt(second) && s2.charAt(first) == s1.charAt(second);
    }
}