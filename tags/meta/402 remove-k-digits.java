/*
https://leetcode.com/problems/remove-k-digits/

维护单调递增栈，因为肯定是从前向后remove digit
而越靠前且越大的值，移除后的剩余结果更小
举例：132，移除3剩下12，移除1剩下32，移除2剩下13，那么剩下的是单调递增的数是最小的
所以维护k范围内的单调递增栈，如果移除的不足k个，从后面继续移除
最后剩余的字符组成的没有leading 0的数即为答案

Time: O(n)
Space: O(n)
*/

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peekLast() > c) {
                k--;
                st.pollLast();
            }
            st.addLast(c);
        }
        while (k > 0) {
            st.pollLast();
            k--;
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) {
            if (c == '0' && res.length() == 0) continue;
            res.append(c);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}