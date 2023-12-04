/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

标准括号计算
如果遇到左括号，当前balance++
如果遇到右括号，如果当前balance是0，证明此时右括号是多余的，那么加到结果中
否则，前面有左括号可以和其匹配，可以balance--
最后的结果即多余的右括号+剩余的没有右括号匹配的左括号，即balance

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                if (balance == 0) {
                    res++;
                    continue;
                }
                balance--;
            }
        }
        return balance + res;
    }
}