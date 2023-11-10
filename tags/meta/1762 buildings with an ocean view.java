/*
https://leetcode.com/problems/buildings-with-an-ocean-view/description/

从右向左扫描，记录当前最大值
大于最大值的下标即可加入结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> l = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) l.add(i);
            max = Math.max(max, heights[i]);
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(res.length - 1 - i);
        }
        return res;
    }
}