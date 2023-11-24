/*
https://leetcode.com/problems/simplify-path/

Time: O(n)
Space: O(n)
*/

class Solution {
    public String simplifyPath(String path) {
        String[] items = path.split("/");
        Stack<String> st = new Stack<>();
        for (String item : items) {
            if (item.equals("") || item.equals(".")) continue;
            else if (item.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else st.push(item);
        }
        StringBuilder res = new StringBuilder();
        for (String s : st) res.append("/" + s);
        return res.length() == 0 ? "/" : res.toString();
    }
}