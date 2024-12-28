/*
https://leetcode.com/problems/multiply-strings/

模拟乘法即可

Time: O(mn)
Space: O(m+n)
*/

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] prod = new int[m + n];
        int idx = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                prod[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = prod.length - 1; i >= 0; i--) {
            int d = (prod[i] + carry) % 10;
            carry = (prod[i] + carry) / 10;
            prod[i] = d;
        }
        for (int num : prod) {
            if (res.length() == 0 && num == 0) continue;
            res.append(num);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}