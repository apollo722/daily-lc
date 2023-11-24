/*
https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

排序后由大到小取偶数位的n个数字和即可
排序可以桶排序以O(n)

Time: O(nlogn)
Space: O(1)，不算排序需要的O(logn)
*/

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3, res = 0;
        for (int i = 3 * n - 2; i > n - 1; i -= 2) res += piles[i];
        return res;
    }
}