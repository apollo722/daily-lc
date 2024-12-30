class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (st.isEmpty() || st.pollLast() != '(') return false;
            } else if (c == ']') {
                if (st.isEmpty() || st.pollLast() != '[') return false;
            } else if (c == '}') {
                if (st.isEmpty() || st.pollLast() != '{') return false;
            } else st.addLast(c);
        }
        return st.isEmpty();
    }
}