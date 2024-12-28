/*
https://leetcode.com/problems/construct-string-from-binary-tree/

preorder traversal
如果已经是叶节点，直接返回
剩下要么是只有左或右节点，要么两个都有
不论是哪种情况，左边一定要继续加进去
而剩下的看右边存不存在，存在即加进去，不存在也就结束了

Time: O(n)
Space: O(h)，worst为O(n)
*/

class Solution {
    StringBuilder cur = new StringBuilder();
    public String tree2str(TreeNode root) {
        build(root);
        return cur.toString();
    }

    private void build(TreeNode root) {
        if (root == null) return;
        cur.append(root.val);
        if (root.left == null && root.right == null) return;
        cur.append('(');
        build(root.left);
        cur.append(")");
        if (root.right != null) {
            cur.append('(');
            build(root.right);
            cur.append(")");
        }
    }
}