/*
https://leetcode.com/problems/baseball-game/

用stack按题意处理即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int top = st.pollLast(), next = st.peekLast() + top;
                st.addLast(top);
                st.addLast(next);
            } else if (s.equals("C")) st.pollLast();
            else if (s.equals("D")) st.addLast(st.peekLast() * 2);
            else st.addLast(Integer.valueOf(s));
        }
        int res = 0;
        for (int num : st) res += num;
        return res;
    }
}