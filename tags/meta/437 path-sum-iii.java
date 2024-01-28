/*
https://leetcode.com/problems/path-sum-iii/

与560 Subarray Sum Equals K类似
对于每一个节点，可以想象成数组中的元素
当curSum==targetSum时，res++
而当map中存在curSum-targetSum时，证明map中存在某一个节点，使得当前节点与map中的节点之间的加和为targetSum
因为是树结构，与数组不同的即在dfs遍历的时候每次回溯到父节点需要将子节点带来的影响重置
即map中要移除curSum，也就是一种backtracking

Time: O(n)
Space: O(n)
*/

class Solution {
    HashMap<Long, Integer> m = new HashMap<>();
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long curSum, int targetSum) {
        if (root == null) return;
        curSum += root.val;
        if (curSum == targetSum) res++;
        res += m.getOrDefault(curSum - targetSum, 0);
        m.put(curSum, m.getOrDefault(curSum, 0) + 1);
        dfs(root.left, curSum, targetSum);
        dfs(root.right, curSum, targetSum);
        m.put(curSum, m.get(curSum) - 1);
    }
}