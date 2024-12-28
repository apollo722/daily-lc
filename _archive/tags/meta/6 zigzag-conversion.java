/*
https://leetcode.com/problems/zigzag-conversion/

模拟来实现
即创造numRows个stringbuilder，遇到第0个就向下走，反之向上走
每次append一个字符

Time: O(n)
Space: O(n)
*/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbArr[i] = new StringBuilder();
        int idx = 0;
        boolean increase = true;
        for (char c : s.toCharArray()) {
            if (idx == 0) {
                increase = true;
            } else if (idx == numRows - 1) increase = false;
            sbArr[idx].append(c);
            if (increase) idx++;
            else idx--;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbArr) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}