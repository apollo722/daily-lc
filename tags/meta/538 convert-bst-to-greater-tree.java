/*
https://leetcode.com/problems/convert-bst-to-greater-tree/

遍历所有节点，但是顺序是先右后中间再左
即当前节点的值，要加上它右侧所有节点值的和
因为反着遍历，所以只要记录下遇到过的节点值的和，即为当前节点的右侧节点值的和
把它加到当前节点身上，再处理左节点就好

Time: O(n)
Space: O(n)
*/

class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}