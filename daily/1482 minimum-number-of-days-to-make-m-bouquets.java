/*
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

二分查找，看哪天开的花能满足条件

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int l = 0, r = 0;
        for (int num : bloomDay) r = Math.max(r, num);
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (calc(bloomDay, mid, k) >= m) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }

    private int calc(int[] bloomDay, int tar , int k) {
        int res = 0, cnt = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= tar) cnt++;
            else cnt = 0;
            if (cnt == k) {
                res++;
                cnt = 0;
            }
        }
        return res;
    }
}