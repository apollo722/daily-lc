/*
https://leetcode.com/problems/smallest-string-starting-from-leaf/

dfs模板，找出所有的从节点出发的string，之后按要求更新字典序最小的

Time: O(n)
Space: O(n)
*/

class Solution {
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String cur) {
        if (root == null) return;
        cur = (char) (root.val + 'a') + cur;
        if (root.left == null && root.right == null) {
            if (res.equals("") || res.compareTo(cur) > 0) {
                res = cur;
            }
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}