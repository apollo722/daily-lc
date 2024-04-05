/*
https://leetcode.com/problems/make-the-string-great/

用stack逐个处理，类似括号匹配

Time: O(n)
Space: O(n)
*/

class Solution {
    public String makeGood(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean push = true;
            if (!st.isEmpty()) {
                if ((char)(st.peekLast() + 32) == c || (char)(st.peekLast() - 32) == c) {
                    st.pollLast();
                    push = false;
                }
            }
            if (push) st.addLast(c);
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) res.append(c);
        return res.toString();
    }
}