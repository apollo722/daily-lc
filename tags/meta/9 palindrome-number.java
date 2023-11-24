/*
https://leetcode.com/problems/palindrome-number/

x小于零必为false
x的尾数为0，亦为false（除了0）
处理x的位数的一半，计算另一个数字，结果要么是二者相等，要么是除去最后一位二者相等

Time: O(logn)，n为输入数字的位数
Space: O(1)
*/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || res / 10 == x;
    }
}