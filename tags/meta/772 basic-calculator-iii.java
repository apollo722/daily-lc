/*
https://leetcode.com/problems/basic-calculator-iii/

计算器模板，记住吧

Time: O(n)
Space: O(1)
*/

class Solution {
    public int calculate(String s) {
        char ops = '+';
        int res = 0, prev = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else if (c == ' ') continue;
            else if (c == '(') {
                int j = i, balance = 0;
                while (j < s.length()) {
                    if (s.charAt(j) == '(') balance++;
                    else if (s.charAt(j) == ')') balance--;
                    if (balance == 0) break;
                    j++;
                }
                cur = calculate(s.substring(i + 1, j));
                i = j;
            } else {
                if (ops == '+' || ops == '-') {
                    if (ops == '+') {
                        res += prev;
                        prev = cur;
                    } else {
                        res += prev;
                        prev = -cur;
                    }
                } else if (ops == '*') {
                    prev *= cur;
                } else prev /= cur;
                cur = 0;
                ops = c;
            }
        }
        if (ops == '+' || ops == '-') {
            if (ops == '+') {
                res += prev;
                prev = cur;
            } else {
                res += prev;
                prev = -cur;
            }
        } else if (ops == '*') {
            prev *= cur;
        } else prev /= cur;
        return res + prev;
    }
}