/*
https://leetcode.com/problems/binary-search-tree-iterator-ii/

如果用inorder transversal来把节点都存在list中当然可以做出来
如果不提前存储，只在必要时候存储，那么就需要用stack将节点都存起来，之后当有需要的时候再找右侧子节点的最左端
同时用一个list来存储已经被next过的值
如果需要的是下一个next，且已经存储的list没那么多值了
那么证明要开始进行入栈操作了，即持续压栈，直到找到最左端，之后记录下当前节点的右节点，以备下次压栈
否则，只需要在list中移动idx即可
注意要特殊处理首项，一开始idx=-1，那么第一个next时idx置为0
此时如果马上call一个prev，那么idx就变成-1了
所以当idx=0时要特殊处理一下prev的逻辑，让他返回0处的值，后再--
其他情况要先--，这是因为一旦idx已经移动了，比如变成了1，那么他的prev是0，而0时的prev不能是-1
也就是首尾不能兼顾，要么特殊处理idx=0的情况，要么特殊处理idx=树节点总数的情况

Time: O(1)，平均时间复杂度
Space: O(n)
*/

class BSTIterator {
    Deque<TreeNode> st;
    List<Integer> arr;
    TreeNode lastNode;
    int idx;

    public BSTIterator(TreeNode root) {
        st = new ArrayDeque<>();
        idx = -1;
        arr = new ArrayList<>();
        lastNode = root;
    }
    
    public boolean hasNext() {
        return !st.isEmpty() || lastNode != null || idx < arr.size() - 1;
    }
    
    public int next() {
        idx++;
        if (idx == arr.size()) {
            while (lastNode != null) {
                st.push(lastNode);
                lastNode = lastNode.left;
            }
            TreeNode cur = st.pop();
            lastNode = cur.right;
            arr.add(cur.val);
        }
        return arr.get(idx);
    }
    
    public boolean hasPrev() {
        return idx > 0;
    }
    
    public int prev() {
        if (idx == 0) return arr.get(idx--);
        return arr.get(--idx);
    }
}