/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

可以递归或者利用stack
也可以O(1) space
iteratively处理每个node，每次先看左孩子是否为null
如果为null，继续处理右孩子
如果不为null，先要找到左孩子的最右节点
因为这个节点将是原节点右孩子的父节点
原节点的右节点即变成了原节点的左孩子
之后左孩子置null


Time: O(n)
Space: O(1)
*/

class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode rightMost = root.left;
                while (rightMost.right != null) rightMost = rightMost.right;
                rightMost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}