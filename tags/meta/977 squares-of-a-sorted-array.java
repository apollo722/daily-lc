/*
https://leetcode.com/problems/squares-of-a-sorted-array/

先找到正负数的分界点，之后用merge sorted array的思路合并即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, p = n, cur = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                p = i;
                break;
            }
        }
        int neg = p - 1;
        while (neg >= 0 || p < n) {
            int d1 = p < n ? nums[p] * nums[p] : -1;
            int d2 = neg >= 0 ? nums[neg] * nums[neg] : -1;
            if (d1 == -1) {
                res[cur++] = d2;
                neg--;
            }
            else if (d2 == -1) {
                res[cur++] = d1;
                p++;
            }
            else if (d1 < d2) {
                res[cur++] = d1;
                p++;
            } else {
                res[cur++] = d2;
                neg--;
            }
        }
        while (neg >= 0) res[cur++] = nums[neg] * nums[neg--];
        while (p < n) res[cur++] = nums[p] * nums[p++];
        return res;
    }
}