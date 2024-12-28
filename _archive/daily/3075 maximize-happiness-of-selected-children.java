/*
https://leetcode.com/problems/maximize-happiness-of-selected-children/

贪心的思路，每次都找最大的
所以就要排序，之后每次取的时候要记录一下现在整体少了多少，加入结果的要考虑整体少的这部分

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int cnt = 0;
        long res = 0;
        Arrays.sort(happiness);
        for (int i = happiness.length - 1; i >= 0; i--) {
            if (k == 0) return res;
            int cur = happiness[i];
            cur -= cnt;
            if (cur <= 0) return res;
            k--;
            cnt++;
            res += cur;
        }
        return res;
    }
}