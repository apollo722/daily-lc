/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

第一次正向扫描
遇到左括号，balance++，并加入
遇到右括号，如果balance == 0，直接略过，否则balance--，并加入
遇到字符，直接加入

第二次反向扫描
多余的左括号就是balance的值
反向扫描直接忽略balance个左括号即可，余下左括号和其他字符直接加入结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        int balance = 0;
        StringBuilder tmp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            tmp.append(c);
        }

        StringBuilder res = new StringBuilder();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            char c = tmp.charAt(i);
            if (c == '(') {
                if (balance-- > 0) continue;
            }
            res.append(c);
        }
        return res.reverse().toString();
    }
}