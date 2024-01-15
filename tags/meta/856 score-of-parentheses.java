/*
https://leetcode.com/problems/score-of-parentheses/

每深入一层，整个结果就要乘以2
在同一层只需要统计balance括号数量即可
找到一个balance括号对，如果长度是2，结果++，否则进入递归并将结果乘2

Time: O(n)
Space: O(n)
*/

class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length(), i = 0, res = 0;
        while (i < n) {
            int j = i, balance = 0;
            while (j < n) {
                if (s.charAt(j) == '(') balance++;
                else balance--;
                if (balance == 0) break;
                j++;
            }
            if (j - i == 1) res++;
            else res += 2 * scoreOfParentheses(s.substring(i + 1, j));
            i = j;
            i++;
        }
        return res;
    }
}