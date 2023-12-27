/*
https://leetcode.com/problems/check-completeness-of-a-binary-tree/

对于一个非full的树来说，一定在某一时刻存在一个空隙
即null后还有非null的节点存在，不论null和非null节点在同一层还是不同层
所以利用BFS遍历所有节点，并记录找到的节点有没有null
如果找到了null，之后还有非null节点，即不是full tree
否则按部就班的将每一个节点的左右节点再放到q中即可
注意遍历full tree的最后一层时，还是会将下一层的全null节点放到q中
但这并不影响，因为要找的是null后的非null节点，如果是null节点，只会标记flag，不会入q左右子节点

Time: O(n)
Space: O(w)
*/

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean foundNull = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                if (foundNull) return false;
                q.add(cur.left);
                q.add(cur.right);
            } else foundNull = true;
        }
        return true;
    }
}