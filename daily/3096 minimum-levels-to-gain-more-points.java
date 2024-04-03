/*
https://leetcode.com/problems/minimum-levels-to-gain-more-points/

求出总和后左边加一个总和就减去一个，找到第一个左边和大于剩余的位置即可
注意至少要给右边留一个位置

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumLevels(int[] possible) {
        int sum = 0;
        for (int num : possible) {
            sum += num == 0 ? -1 : 1;
        }
        int cur = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            cur += possible[i] == 0 ? -1 : 1;
            if (cur > sum - cur) return i + 1;
        }
        return -1;
    }
}