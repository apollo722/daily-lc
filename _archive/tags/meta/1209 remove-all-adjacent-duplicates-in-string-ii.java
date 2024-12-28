/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

利用stack来存储之前的<ch,cnt> pair，一个个处理即可

Time: O(n)
Space: O(n)
*/

class Solution {
    class P {
        char ch;
        int cnt;
        P (char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<P> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == c) {
                st.peek().cnt += 1;
                if (st.peek().cnt == k) st.pop();
            } else st.push(new P(c, 1));
        }
        StringBuilder res = new StringBuilder();
        for (P p : st) {
            for (int i = 0; i < p.cnt; i++) res.append(p.ch);
        }
        return res.toString();
    }
}