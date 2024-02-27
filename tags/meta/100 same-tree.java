/*
https://leetcode.com/problems/same-tree/

dfs逐个检查，类似101
即如果两个节点同时为null，为true
任何一个为null，证明另一个不为null，即为false
在当前节点值相等的情况下继续检查左节点的左孩子与右节点的左孩子，和左节点的右孩子与右节点的右孩子是否都相等

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}