/*
https://leetcode.com/problems/furthest-building-you-can-reach/

贪心，最长的gap用梯子，剩下的用砖块，用完为止
所以用min pq来pop最小的gap，即pq中都是gap里面最大的，以先消耗梯子
pq size超过梯子时，pop出来的就一定是消耗砖块的
消耗完砖块就返回目前的位置，反之则继续前进

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                pq.add(diff);
                if (pq.size() > ladders) bricks -= pq.poll();
                if (bricks < 0) return res;
            }
            res++; 
        }
        return res;
    }
}