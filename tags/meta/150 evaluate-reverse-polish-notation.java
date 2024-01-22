/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/

用stack顺序处理即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        for (String s : tokens) {
            int cur = 0;
            if (ops.contains(s)) {   
                cur = calc(st.pollLast(), st.pollLast(), s);
            } else cur = Integer.valueOf(s);
            st.addLast(cur);
        }
        return st.pollLast();
    }

    private int calc(int b, int a, String s) {
        int res = 0;
        if (s.equals("+")) res = a + b;
        else if (s.equals("-")) res = a - b;
        else if (s.equals("*")) res = a * b;
        else res = a / b;
        return res;
    }
}