/*
https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

递归模板，扫描每一个节点，看和它父节点的关系如何
如果是连续递增，curLen+1，否则重置curLen
在这过程中实时更新最大长度

Time: O(n)
Space: O(n)
*/

class Solution {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 1);
        return maxLen;
    }

    private void dfs(TreeNode root, TreeNode parent, int curLen) {
        if (root == null) return;
        if (parent != null) {
            if (parent.val + 1 == root.val) curLen++;
            else curLen = 1; 
        }
        maxLen = Math.max(maxLen, curLen);
        dfs(root.left, root, curLen);
        dfs(root.right, root, curLen);
    }
}