/*
https://leetcode.com/problems/inorder-successor-in-bst/

首先目标节点的后继一定在目标节点的右侧
所以如果当前节点的值大于或等于目标节点，证明整个左子树都没用了，直接root=root.right
反之，当前节点的值小于目标节点了，那么可能当前节点就是答案，也有可能还在左子树
那么记录上当前节点，并向左移动
如此iterativly遍历所有节点即可

Time: O(n)
Space: O(1)
*/


class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        while (root != null) {
            if (p.val >= root.val) root = root.right;
            else {
                prev = root;
                root = root.left;
            }
        }
        return prev;
    }
}