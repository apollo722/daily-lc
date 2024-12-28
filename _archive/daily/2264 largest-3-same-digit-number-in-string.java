/*
https://leetcode.com/problems/largest-3-same-digit-number-in-string/

顺序扫描找到最大的数字即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int res = -1;
        for (int i = 1; i < n - 1; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i - 1) && c == num.charAt(i + 1)) res = Math.max(res, c - '0');
        }
        if (res == -1) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) sb.append(res);
        return sb.toString();
    }
}