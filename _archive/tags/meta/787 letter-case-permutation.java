/*
https://leetcode.com/problems/find-the-winner-of-the-circular-game/

backtracking模板，每个位置都试一遍枚举即可

Time: O(n 2^n)
Space: O(n 2^n)
*/

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(s, 0, "");
        return res;
    }

    private void backtrack(String s, int idx, String curStr) {
        if (s.length() == idx) {
            res.add(curStr);
            return;
        }
        char c = s.charAt(idx);
        if (Character.isLetter(c)) {
            backtrack(s, idx + 1, curStr + Character.toLowerCase(c));
            backtrack(s, idx + 1, curStr + Character.toUpperCase(c));
        } else backtrack(s, idx + 1, curStr + c);
    }
}