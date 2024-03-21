/*
https://leetcode.com/problems/path-sum/

递归处理每个节点，遇到叶节点且当前累积的和满足条件即可返回

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int nextTarget = targetSum - root.val;
        if (root.left == null && root.right == null && nextTarget == 0) return true;
        return hasPathSum(root.left, nextTarget) || hasPathSum(root.right, nextTarget);
    }
}