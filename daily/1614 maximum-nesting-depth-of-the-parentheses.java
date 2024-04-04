/*
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

用balance来track最大的左括号数，标准括号检查

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxDepth(String s) {
        int balance = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
                if (balance > res) res = balance;
            } else if (s.charAt(i) == ')') balance--;
        }
        return res;
    }
}