/*
https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

标准st回溯，和括号题没有什么本质不同
就是看每次遇到c，前面会不会有ab去组成abc
能组成就继续看，否则直接返回false

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = true;
            if (c == 'c') {
                if (st.size() >= 2) {
                    char c1 = st.pollLast(), c2 = st.pollLast();
                    if (c1 != 'b' || c2 != 'a') return false;
                    flag = false;
                } else return false;
            }
            if (flag) st.addLast(c);   
        }
        return st.isEmpty();
    }
}