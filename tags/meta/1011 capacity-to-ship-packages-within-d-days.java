/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

利用二分查找找到最小所需天数即可
二分查找的下界是weights中的最大值，上界是weights的和

Time: O(log(sum(weights)))
Space: O(1)
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[0], r = 0, res = -1;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int need = calc(weights, mid);
            if (need > days) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    private int calc(int[] arr, int k) {
        int res = 1, curSum = 0;
        for (int num : arr) {
            if (curSum + num <= k) {
                curSum += num;
            } else {
                res++;
                curSum = num;
            }
        }
        return res;
    }
}