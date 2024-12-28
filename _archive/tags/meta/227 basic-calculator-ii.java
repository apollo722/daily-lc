/*
https://leetcode.com/problems/basic-calculator-ii/

经典模板题，记住它

Time: O(n)
Space: O(1)
*/

class Solution {
    public int calculate(String s) {
        int curNum = 0, prevNum = 0, res = 0;
        char ops = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) curNum = curNum * 10 + c - '0';
            else {
                if (ops == '+' || ops == '-') {
                    if (ops == '+') {
                        res += prevNum;
                        prevNum = curNum;
                    } else {
                        res += prevNum;
                        prevNum = -curNum;
                    }
                } else if (ops == '*') {
                    prevNum *= curNum;
                } else {
                    prevNum /= curNum;
                }
                curNum = 0;
                ops = c;
            }
        }
        if (ops == '+' || ops == '-') {
            if (ops == '+') {
                res += prevNum;
                prevNum = curNum;
            } else {
                res += prevNum;
                prevNum = -curNum;
            }
        } else if (ops == '*') {
            prevNum *= curNum;
        } else {
            prevNum /= curNum;
        }
        return res + prevNum;
    }
}