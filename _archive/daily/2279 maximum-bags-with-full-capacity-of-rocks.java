/*
https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/

将差值排序后从最小的袋子greedy取，直到剩余rock不足

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = capacity[i] - rocks[i];
        Arrays.sort(arr);
        int res = 0;
        for (int num : arr) {
            additionalRocks -= num;
            if (additionalRocks >= 0) res++;
            else break;
        }
        return res;
    }
}