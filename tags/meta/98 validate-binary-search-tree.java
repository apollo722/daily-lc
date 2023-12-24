/*
https://leetcode.com/problems/validate-binary-search-tree/

递归分别处理两侧的子树，利用当前节点的值和上层传递下来的值作为边界即可
因为节点值可能含有Integer.MAX_VALUE/MIN_VALUE，所以要用Long的最大最小值作为边界
也可以利用Integer的null作为边界只check一边，即if (low/hight != null && ...)

Time: O(n)
Space: O(h)
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root.left, Long.MIN_VALUE, root.val) && check(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long left, long right) {
        if (node == null) return true;
        if (node.val <= left || node.val >= right) return false;
        return check(node.left, left, node.val) && check(node.right, node.val, right);
    }
}