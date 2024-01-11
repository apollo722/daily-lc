/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

dfs每个节点，只要记录下到目前为止最大和最小值即可，因为到任何一个节点不论最大值还是最小值都来自于祖先

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return res;
        check(root, root.val, root.val);
        return res;
    }

    private void check(TreeNode root, int s, int l) {
        if (root == null) return;
        res = Math.max(Math.max(res, l - root.val), root.val - s);
        check(root.left, Math.min(root.val, s), Math.max(root.val, l));
        check(root.right, Math.min(root.val, s), Math.max(root.val, l));
    }
}