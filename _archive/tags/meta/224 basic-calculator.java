/*
https://leetcode.com/problems/basic-calculator/

计算器模板

Time: O(n)
Space: O(1)
*/

class Solution {
    int i = 0;
    public int calculate(String s) {
        int res = 0, curNum = 0, prevNum = 0;
        char ops = '+';
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i++);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) curNum = curNum * 10 + c - '0';
            else if (c == '(') {
                curNum = calculate(s);
            } else if (c == ')') break;
            else {
                if (ops == '+') {
                    res += prevNum;
                    prevNum = curNum;
                } else {
                    res += prevNum;
                    prevNum = -curNum;
                }
                ops = c;
                curNum = 0;
            }
        }
        if (ops == '+') {
            res += prevNum;
            prevNum = curNum;
        } else {
            res += prevNum;
            prevNum = -curNum;
        }
        return res + prevNum;
    }
}