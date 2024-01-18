/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

可以二分查找，每次只找一半的树，统计每个节点的size，如果是第k个直接返回，否则分别计算左右子树
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftSize = size(root.left);
        if (leftSize == k - 1) return root.val;
        else if (leftSize < k - 1) return kthSmallest(root.right, k - 1 - leftSize);
        else return kthSmallest(root.left, k);
    }

    private int size(TreeNode root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }
}
Time: O(n^2)
Space: O(n)

也可以利用BST inorder有序的性质，通过inorder遍历直接找到第k个

Time: O(n)
Space: O(n)
*/

class Solution {
    int cnt = 0, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        cnt--;
        if (cnt == 0) {
            res = node.val;
            return;
        }
        inorder(node.right);
    }
}