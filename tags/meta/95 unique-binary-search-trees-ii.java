/*
https://leetcode.com/problems/unique-binary-search-trees-ii/

时间空间复杂度见：https://leetcode.com/problems/unique-binary-search-trees-ii/editorial/
空间可以更优化

Time: ?
Space: ?
*/

class Solution {
    HashMap<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        Pair<Integer, Integer> p = new Pair(start, end);
        if (memo.containsKey(p)) return memo.get(p);
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generate(start, i - 1), rightList = generate(i + 1, end);
            for (TreeNode l : leftList) {
                for (TreeNode r : rightList) {
                    TreeNode root = new TreeNode(i, l, r);
                    res.add(root);
                }
            }
        }
        memo.put(p, res);
        return res;
    }
}