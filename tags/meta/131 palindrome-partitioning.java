/*
https://leetcode.com/problems/palindrome-partitioning/

带记忆数组的backtracking模板
每个位置都判断一下可否加入list，判断的条件即当前substr是不是回文
利用记忆数组可以快速的判断任何两个位置之间是否形成回文

Time: O(n 2^n)
Space: O(n^2)
*/

class Solution {
    List<List<String>> res = new ArrayList<>();
    Boolean[][] memo;
    public List<List<String>> partition(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        solve(s, 0, new ArrayList<>());
        return res;
    }

    private void solve(String s, int idx, List<String> curList) {
        if (idx >= s.length()) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isValid(s, idx, i)) {
                curList.add(s.substring(idx, i + 1));
                solve(s, i + 1, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isValid(String s, int l, int r) {
        if (l >= r) return true;
        if (memo[l][r] != null) return memo[l][r];
        return s.charAt(l) == s.charAt(r) && isValid(s, l + 1, r - 1);
    }
}