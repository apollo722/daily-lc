/*
https://leetcode.com/problems/balanced-binary-tree/

递归处理
如果用自定数据结构存储信息由下往上检查，运行速度会更快，可以提前剪枝达到O(n)时间复杂度
https://leetcode.com/problems/balanced-binary-tree/editorial/

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        return diff < 2 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}