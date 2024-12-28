/*
https://leetcode.com/problems/maximum-width-of-binary-tree/

层序遍历模板
给每一个节点标号，根节点为i的话，左节点即是2i，右节点2i+1
每一层找到首尾的节点计算标号差值即可

Time: O(n)
Space: O(n)
*/

class Solution {
    class Node {
        TreeNode node;
        int rank;
        Node(TreeNode node, int rank) {
            this.node = node;
            this.rank = rank;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 1));
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int levelMax = 0, levelMin = 0;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == 0) levelMin = cur.rank;
                if (i == size - 1) levelMax = cur.rank;
                if (cur.node.left != null) q.add(new Node(cur.node.left, cur.rank * 2 - 1));
                if (cur.node.right != null) q.add(new Node(cur.node.right, cur.rank * 2));
            }
            res = Math.max(res, levelMax - levelMin + 1);
        }
        return res;
    }
}