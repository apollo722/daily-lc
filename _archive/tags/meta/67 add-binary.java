/*
https://leetcode.com/problems/add-binary/

标准相加字符串

Time: O(max(m,n))
Space: O(1)
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int m = a.length(), n = b.length(), i = m - 1, j = n - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int d2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int total = d1 + d2 + carry;
            carry = total >= 2 ? 1 : 0;
            res.append(total % 2 + "");
        }
        if (carry > 0) res.append("1");
        return res.reverse().toString();
    }
}