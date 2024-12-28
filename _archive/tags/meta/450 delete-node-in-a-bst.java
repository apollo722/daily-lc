/*
https://leetcode.com/problems/delete-node-in-a-bst/

对于BST，删除掉节点要么被前一个最大节点顶替，要么被后一个最小节点顶替
如果是叶节点，直接置为null，等同于删除
如果存在左孩子，即存在前一个节点，那么找到它并递归的将左子树的前一个节点删除
反之亦然

Time: O(logn)
Space: O(h)，h为height of the tree
*/

class Solution {
    private int getPrev(TreeNode node) {
        node = node.left;
        while (node.right != null) node = node.right;
        return node.val;
    }
    private int getNext(TreeNode node) {
        node = node.right;
        while (node.left != null) node = node.left;
        return node.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root.val = getNext(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = getPrev(root);
                root.left = deleteNode(root.left, root.val);
            }
        } else if (root.val < key) root.right = deleteNode(root.right, key);
        else root.left = deleteNode(root.left, key); 
        return root;
    }
}