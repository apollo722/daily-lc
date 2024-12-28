/*
https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/

模板化的序列与反序列化问题
用StringBuilder存储每个节点的值，并用","隔开每个节点，用特殊字符代替null
因为每一个节点不一定有多少个子节点，所以要把子节点个数也存进去
反序列化时，如果节点不为null，下一个数字一定是子节点个数
根据子节点个数递归构造树

Time: O(n)
Space: O(n)
*/

class Codec {
    public String serialize(Node root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        return res.toString();
    }

    private void dfs(Node root, StringBuilder res) {
        res.append(root == null ? "#," : root.val + ",");
        if (root == null) return;
        res.append(root.children.size() + ",");
        for (Node next : root.children) {
            dfs(next, res);
        }
    }
	
    public Node deserialize(String data) {
        int[] idx = {0};
        String[] arr = data.split(",");
        return build(arr, idx);
    }

    private Node build(String[] arr, int[] idx) {
        String cur = arr[idx[0]++];
        if (cur.equals("#")) return null;
        Node root = new Node(Integer.valueOf(cur));
        int size = Integer.valueOf(arr[idx[0]++]);
        List<Node> children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            children.add(build(arr, idx));
        }
        root.children = children;
        return root;
    }
}