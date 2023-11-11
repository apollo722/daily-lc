/*
https://leetcode.com/problems/random-pick-with-weight/

建立前缀和数组
比如初始元素[1, 3]，前缀和就是[1, 4]
二分查找0~3，0 -> 1, 1/2/3 -> 4
即，寻找第一个大于随机数的下标

Time: O(n)建立pre-sum数组，O(logn)返回随机下标
Space: O(n)
*/

class Solution {
    int[] preSum;
    int n;
    Random rand = new Random();
    public Solution(int[] w) {
        n = w.length;
        preSum = new int[n];
        preSum[0] = w[0];
        for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + w[i];
    }
    
    public int pickIndex() {
        int tar = rand.nextInt(preSum[n - 1]);
        int l = 0, r = n - 1, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] <= tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}