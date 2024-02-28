/*
https://leetcode.com/problems/valid-parentheses/

利用stack来存储每一个左括号，当遇到右括号时，看stack是否为空，若不为空stack头应该是对应的右括号
最后要看stack是否为空，不为空证明有未匹配的左括号，故需返回false

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.isEmpty()) return false;
                if (c == ')' && st.peek() != '(') return false;
                if (c == ']' && st.peek() != '[') return false;
                if (c == '}' && st.peek() != '{') return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}