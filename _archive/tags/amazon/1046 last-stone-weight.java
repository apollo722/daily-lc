/*
https://leetcode.com/problems/last-stone-weight/

按照题意模拟，每次处理完石头再把剩余的排序

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int i = stones.length - 1;
        while (i > 0) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones, 0, i);
            i--;
        }
        return stones[0];
    }
}