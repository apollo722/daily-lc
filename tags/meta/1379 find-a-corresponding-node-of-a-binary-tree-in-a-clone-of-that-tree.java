/*
https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

同时DFS两棵树，找到匹配assign给结果
注意可以提前减枝，左子树找到结果就不用遍历剩余树了

Time: O(n)
Space: O(n)
*/

class Solution {
    TreeNode res = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);
        return res;
    }

    private void dfs(TreeNode ori, TreeNode copy, TreeNode tar) {
        if (ori == null) return;
        if (ori == tar) {
            res = copy;
            return;
        }
        dfs(ori.left, copy.left, tar);
        if (res != null) return;
        dfs(ori.right, copy.right, tar);
    }
}