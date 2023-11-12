/*
https://leetcode.com/problems/binary-search-tree-iterator/

用Stack存left most
每次pop后，都找右节点的left most

Time: O(n)，最坏情况是O(n)，平均下来是O(1)，因为不是每次next() call都需要入栈操作
Space: O(n)
*/

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode resNode = st.pop();
        TreeNode leftMost = resNode.right;
        if (leftMost != null) {
            while (leftMost != null) {
                st.push(leftMost);
                leftMost = leftMost.left;
            }
        }
        return resNode.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}