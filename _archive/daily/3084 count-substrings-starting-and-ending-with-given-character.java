/*
https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/

统计出现过多少次字符c，假设频率为cnt
那么第一个c可以和后面的cnt-1个分别组合，再加上它自己，即cnt个substr
第二个c可以和后面cnt-2个分别组合，加上自己即cnt-1个substr
以此类推，最后一个c只能和它自己组成substr，即为1，故结果为一个等差数列求和

Time: O(n)
Space: O(1)
*/

class Solution {
    public long countSubstrings(String s, char c) {
        long cnt = 0;
        for (int i = 0; i < s.length(); i++) if (c == s.charAt(i)) cnt++;
        return cnt * (cnt + 1) / 2;
    }
}