/*
https://leetcode.com/problems/complete-binary-tree-inserter/

利用层序遍历的思想，用q来存储每一层，只不过这里的层不是真的层，而是下一个有空位的节点
构建的时候先把root放入q中（题目规定构建时root一定满编）
因为要始终保证q头部节点是有空位的，所以如果q头部节点右子节点非空，证明它是满编
所以要把队头poll出，之后加入队头的左右子节点
insert时，因为每次队首一定有空位，所以放到队首节点的空位上
如果insert后队首满编了，那么就要出队，并把出队节点的左右节点入队
这样队列里的节点都是按照层序遍历排列的，保证下一个队首节点总是有空位的，即下一个需要安排满的节点

Time: O(n)
Space: O(n_cur)，取决于insert的次数
*/

class CBTInserter {
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        q.add(root);
        while (q.peek().right != null) {
            TreeNode parent = q.poll();
            q.add(parent.left);
            q.add(parent.right);
        }
    }
    
    public int insert(int val) {
        TreeNode parent = q.peek();
        if (parent.left == null) parent.left = new TreeNode(val);
        else {
            parent.right = new TreeNode(val);
            TreeNode next = q.poll();
            q.add(next.left);
            q.add(next.right);
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;        
    }
}