/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

利用上一层来处理下一层
先利用node.left来找到每一层的第一个node

之后遍历该层，使得：
node.left.next = node.right
如果node.next存在，说明node不是本层最后一个node，那么其right必然也可以继续向右链接，即：
node.right.next = node.next.left

当该层起点不再拥有left时，即结束循环

Time: O(n)
Space: O(1)
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node nextStart = root;
        while (nextStart.left != null) {
            Node cur = nextStart;
            nextStart = cur.left;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
        }
        return root;
    }
}