/*
https://leetcode.com/problems/add-strings/

反向的字符串相加

Time: O(n)
Space: O(1)
*/

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int total = d1 + d2 + carry;
            int d = total % 10;
            carry = total / 10;
            i--;
            j--;
            res.append(d + "");
        }
        if (carry > 0) res.append(carry + "");
        return res.reverse().toString();
    }
}