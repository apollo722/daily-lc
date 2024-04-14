/*
https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

要找到两个str长度的最大公约数
但是找到了也不一定就可以，要先看str1+str2与str2+str1是否是一样的
如果不一样，无论如何也拼不出来
如果一样，最大公约数的substr就是结果

Time: O(m + n)
Space: O(m + n)
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}