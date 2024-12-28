/*
https://leetcode.com/problems/clone-graph/

DFS探索图，也可以BFS

Time: O(v + e)，v为node数，e为edge数
Space: O(h)，h为图的height（如果是BFS，queue中最多可以存O(w)节点，w为图的宽度），worst情况为O(v)
*/

class Solution {
    HashMap<Node, Node> m = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (m.containsKey(node)) return m.get(node);
        Node copy = new Node(node.val);
        m.put(node, copy);
        for (Node next : node.neighbors) {
            copy.neighbors.add(cloneGraph(next));
        }
        return copy;
    }
}