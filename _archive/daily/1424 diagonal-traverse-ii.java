/*
https://leetcode.com/problems/diagonal-traverse-ii/

将每一条对角线想象成tree的一层，这样就可以利用BFS层序遍历来仅扫一遍输入数据
只有每一行的第一个元素需要考虑其下面的元素，其他元素仅考虑其右侧元素即可去重

Time: O(n)
Space: O(sqrt(n))，不算最后结果所占的space，BSF queue中存储最大为最长的对角线，不会超过sqrt(n)
*/

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        List<Integer> resList = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair<Integer, Integer> curP = q.poll();
            int i = curP.getKey(), j = curP.getValue();
            resList.add(nums.get(i).get(j));
            if (j == 0 && i + 1 < nums.size()) q.add(new Pair(i + 1, j));
            if (j + 1 < nums.get(i).size()) q.add(new Pair(i, j + 1));
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) res[i] = resList.get(i);
        return res;
    }
}