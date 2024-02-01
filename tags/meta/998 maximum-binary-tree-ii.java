/*
https://leetcode.com/problems/maximum-binary-tree-ii/

首先要理解题目要干啥，根据654，构建树的时候找到最大值之后，数组最大值左侧会递归构建为左子树，右侧构建为右子树
题目说是append一个数字在给定树展开之后的数组后，即这个数字要么称为根节点，要么就一定在右侧
因为数组最后append的数字要么是某一段数组的最大值，成为了根，要么就被构建成了某一个节点的右子树
所以如果val比当前根节点的值大，那么它将会成为新的根，且原根变成了左子树（这是因为val永远在数组最后，左边的一切都是左子树的一部分）
而如果val不如当前根节点的值大，那么他一定是被插到右子树的某个位置，递归求解即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}