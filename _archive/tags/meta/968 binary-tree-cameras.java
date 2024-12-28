/*
https://leetcode.com/problems/binary-tree-cameras/

如果一个cam在叶子上，能cover的区域是叶子的子节点和父节点
所以从下往上推，任意节点如果左右任何一个节点有cam，那么当前节点就不需要cam了
如果任何一个子节点需要cam，那么当前节点就要放一个cam
如果不满足上面的情况，那么证明这个节点需要一个cam，即没有子节点上有cam，也不需要cam（即已被cover，被更下一层）
但这一层需要cam和放一个cam的区别是，并不是需要了就要放，因为可以等再上一层放置来同时cover上层，上上层，和本层，属于有点贪心

那么规定如果一个节点需要cam，返回0
已经有一个cam了，返回1
已经被cam cover了，返回2

递归的逐层看需不需要cam
如果节点是null，证明不需要，相当于被cover，返回2
递归检查左右
任何一个节点返回0，证明当前节点要放一个cam，以cover某个子节点，所以放置cam，结果++，返回1
如果任何一个节点返回1，证明当前节点作为父节点被子节点cover了， 返回2即可
如果不满足以上情况（起始就是左右两个节点都返回了2，比如一个叶节点），那么证明当前是没被cover，需要一个cam，返回0
最后再看root的返回值，如果是0，证明root需要一个cam，最后加1即可

Time: O(n)
Space: O(h)
*/

class Solution {
    /*
        0: need a cam
        1: has a cam
        2: covered by a cam
    */
    int res = 0;
    
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int need = calc(root);
        if (need < 1) return res + 1;
        return res;
    }

    private int calc(TreeNode root) {
        if (root == null) return 2;
        int left = calc(root.left), right = calc(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;
        return 0;
    }
}