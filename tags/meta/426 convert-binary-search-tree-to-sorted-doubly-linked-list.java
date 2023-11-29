/*
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

利用recursion和inorder traversal逐个节点链接
有O(1) space的解法：https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solutions/534869/JavaScript-Morris-In-Order-Traversal-O(n)-Time-O(1)-Space/

Time: O(n)
Space: O(h)，最worst情况O(n)
*/

class Solution {
    Node first = null, last = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        traverse(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void traverse(Node node) {
        if (node == null) return;
        traverse(node.left);
        if (last != null) {
            last.right = node;
            node.left = last;
        } else first = node;
        last = node;
        traverse(node.right);
    }
}