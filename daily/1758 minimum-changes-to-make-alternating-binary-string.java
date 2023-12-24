/*
https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

贪心的找两次，即以0为起点或以1为起点即可
也可以观察到，以1为起点的操作数一定是n-以0为起点的操作数
因为如果一个位置在1为起始的时候不满足条件，那在以0为起始的时候一定就满足条件了

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minOperations(String s) {
        char p = s.charAt(0);
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (p == c) {
                res++;
                p = c == '1' ? '0' : '1';
            } else p = c;
        }
        return Math.min(res, s.length() - res);
    }
}