public class Codec {
    StringBuilder res = new StringBuilder();
    public String serialize(TreeNode root) {
        build(root);
        return res.toString();
    }

    private void build(TreeNode root) {
        if (root == null) {
            res.append("#,");
            return;
        }
        res.append(root.val + ",");
        build(root.left);
        build(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] treeArr = data.split(",");
        return rebuild(treeArr);
    }
    int idx = 0;
    private TreeNode rebuild(String[] arr) {
        if (idx == arr.length - 1) return null;
        if (arr[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[idx++]));
        root.left = rebuild(arr);
        root.right = rebuild(arr);
        return root;
    }
}