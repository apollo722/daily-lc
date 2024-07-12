/*
https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

简单循环模拟即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else res.append(s.charAt(i));
        }
        return res.toString();
    }
}