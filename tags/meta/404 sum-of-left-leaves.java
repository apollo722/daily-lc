/*
https://leetcode.com/problems/sum-of-left-leaves/

求左叶节点的和，递归标记每个节点，左边的就是true，右边的就是false
遇到叶节点且还是左边的，就加到结果
注意如果只有一个根节点是不属于左节点的，所以一开始root要标记false

Time: O(n)
Space: O(n)
*/

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return calc(root, false);
    }

    private int calc(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (isLeft && node.left == null && node.right == null) return node.val;
        return calc(node.left, true) + calc(node.right, false);
    }
}