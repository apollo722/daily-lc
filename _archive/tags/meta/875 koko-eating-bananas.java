/*
https://leetcode.com/problems/koko-eating-bananas/

二分法，每次找到一个k，来计算所需要的时间
如果需要时间大于给定时间，则需要增加k，反之记录下位置之后减少k

Time: O(nlogm)，m为piles中的最大值，二分m需要logm，每次计算需要n
Space: O(1)
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int num : piles) if (max < num) max = num;
        int l = 1, r = max, res = 0;
        while (l <= r) {
            int k = l + (r - l) / 2;
            int hrs = calc(piles, k);
            if (hrs > h) l = k + 1;
            else {
                res = k;
                r = k - 1;
            }
        }
        return res;
    }

    private int calc(int[] piles, int k) {
        int res = 0;
        for (int p : piles) {
            res += Math.ceil(1.0 * p / k);
        }
        return res;
    }
}