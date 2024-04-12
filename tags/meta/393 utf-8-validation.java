/*
https://leetcode.com/problems/utf-8-validation/

理解+编程题
对于任何一个数字，它的二进制表达只有四种情况
要么开始是0，要么开始是110，1110，11110
如果不是0，那么它后面跟着的几个数字必须是10开头，且个数是1的个数-1
用两个mask分别用来找到数字的第一和第二位，按照规则逐一检查即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean validUtf8(int[] data) {
        int curByte = 0, mask1 = 1 << 7, mask2 = 1 << 6;
        for (int num : data) {
            if (curByte == 0) {
                int mask = 1 << 7;
                while ((mask & num) != 0) {
                    curByte++;
                    mask >>= 1;
                }
                if (curByte == 0) continue;
                if (curByte > 4 || curByte == 1) return false;
            } else {
                if (!((num & mask1) != 0 && (mask2 & num) == 0)) return false;
            }
            curByte--;
        }
        return curByte == 0;
    }
}