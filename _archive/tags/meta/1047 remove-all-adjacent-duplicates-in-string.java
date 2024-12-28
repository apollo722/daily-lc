/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

利用stack逐个处理，如果和之前的一样，就pop之前的
否则push

Time: O(n)
Space: O(n)
*/

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peekLast() == c) {
                st.pollLast();
            } else st.addLast(c);
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) res.append(c);
        return res.toString();
    }
}