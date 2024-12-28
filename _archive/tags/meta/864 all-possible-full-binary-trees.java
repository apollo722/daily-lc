/*
https://leetcode.com/problems/all-possible-full-binary-trees/

想要每个节点只有0或2个子节点，n必须要为奇数
如果n为1，直接返回一个节点
否则要recursively的建立左右子树，左边为i，右边为n-1-i个
利用memo来存储已经找到的结果即可加速

Time: O(2^(n/2))，总共有n-2个node可以在左子树，所以T(n)=T(1)*T(n - 2)+T(3)*T(n - 4)+...+T(n - 2)*T(1)=2^(n/2)
Space: O(n 2^(n/2))
*/

class Solution {
    HashMap<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        if (n == 1) return Arrays.asList(new TreeNode());
        if (memo.containsKey(n)) return memo.get(n);
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> l = allPossibleFBT(i), r = allPossibleFBT(n - 1 - i);
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode root = new TreeNode(0, left, right);
                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }
}