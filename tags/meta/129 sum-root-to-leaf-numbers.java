/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/

preorder traversal
（有O(1) space的traversal算法：Morris Preorder Traversal）

Time: O(n)
Space: O(h)，h为tree height，worst O(n)
*/

class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return res;
        calc(root, 0);
        return res;
    }

    private void calc(TreeNode node, int curNum) {
        if (node == null) return;
        curNum = curNum * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += curNum;
            return;
        }
        calc(node.left, curNum);
        calc(node.right, curNum);
    }
}