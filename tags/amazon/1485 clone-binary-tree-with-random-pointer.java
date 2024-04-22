/*
https://leetcode.com/problems/clone-binary-tree-with-random-pointer/

DFS模板
用map存老新节点的对应，之后分别处理左右random即可
与遍历树并没有什么不同，random的存在没有改变题目性质

Time: O(n)
Space: O(n)
*/

class Solution {
    HashMap<Node, NodeCopy> m = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        return dfs(root);
    }

    private NodeCopy dfs(Node root) {
        if (root == null) return null;
        if (m.containsKey(root)) return m.get(root);
        NodeCopy res = new NodeCopy(root.val);
        m.put(root, res);
        res.left = dfs(root.left);
        res.right = dfs(root.right);
        res.random = dfs(root.random);
        return res;
    }
}