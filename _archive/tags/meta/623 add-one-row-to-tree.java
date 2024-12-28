/*
https://leetcode.com/problems/add-one-row-to-tree/

利用层序遍历，当处于第depth-1层时，把所有node都都按要求接一层1即可

Time: O(n)
Space: O(w)
*/

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curDepth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                TreeNode curNode = q.poll();
                if (curDepth == depth - 1) {
                    TreeNode newLeft = new TreeNode(val), newRight = new TreeNode(val);
                    newLeft.left = curNode.left;
                    newRight.right = curNode.right;
                    curNode.left = newLeft;
                    curNode.right = newRight;
                } else {
                    if (curNode.left != null) q.add(curNode.left);
                    if (curNode.right != null) q.add(curNode.right);
                }
                
            }
            curDepth++;
        }
        return root;
    }
}