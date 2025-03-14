class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, n);
        return res;
    }

    private void backtrack(StringBuilder cur, int left, int right) {
        if (left < 0) return;
        if (left == 0 && right == 0) {
            res.add(cur.toString());
            return;
        }
        if (left < right) {
            cur.append(')');
            backtrack(cur, left, right - 1);
            cur.deleteCharAt(cur.length() - 1);
        }
        cur.append('(');
        backtrack(cur, left - 1, right);
        cur.deleteCharAt(cur.length() - 1);
    }
}