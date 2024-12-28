/*
https://leetcode.com/problems/generate-parentheses/

backtrack模板

Time: O(4^n/sqrt(n))，解释见https://leetcode.com/problems/generate-parentheses/editorial/
Space: O(n)
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int left, int right, StringBuilder cur, List<String> res) {
        if (left < 0) return;
        if (left == 0 && right == 0) {
            res.add(cur.toString());
            return;
        }
        cur.append('(');
        backtrack(left - 1, right, cur, res);
        cur.deleteCharAt(cur.length() - 1);
        if (left < right) {
            cur.append(')');
            backtrack(left, right - 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        } 
    }
}