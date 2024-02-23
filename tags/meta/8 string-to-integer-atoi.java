/*
https://leetcode.com/problems/string-to-integer-atoi/

首先先trim前后多余的空格
之后检查第一位是不是符号，如果是符号标记一下
之后常规的每一个数字位来构造结果，要在可能越界前结束构造
2147483647
-2147483648
如果加上下一位超过了最大范围，或者此刻刚好等于214748364，而下一位比7还要大，那么就一定是超过整型范围的

Time: O(n)
Space: O(n)，转化成char array所需的空间
*/

class Solution {
    public int myAtoi(String str) {
        char[] s = str.trim().toCharArray();
        if (s.length == 0) return 0;
        boolean sign = false;
        int i = 0;
        if (s[i] == '-' || s[i] == '+') {
            sign = s[i] == '+' ? false : true;
            i++;
        }
        int res = 0;
        while (i < s.length && s[i] >= '0' && s[i] <= '9') {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s[i] > '7')) {
                if (sign) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            res = res * 10 + s[i] - '0';
            i++;
        }
        return sign == true ? -res : res;
    }
}