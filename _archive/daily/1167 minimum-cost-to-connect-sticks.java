/*
https://leetcode.com/problems/minimum-cost-to-connect-sticks/

贪心的每次都找最短的两个stick加一起
用到优先队列不断地找两根最小的stick
过程中记录所需要的cost即可

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : sticks) pq.add(num);
        int res = 0;
        while (pq.size() > 1) {
            int curSum = pq.poll() + pq.poll();
            res += curSum;
            pq.add(curSum);
        }
        return res;
    }
}