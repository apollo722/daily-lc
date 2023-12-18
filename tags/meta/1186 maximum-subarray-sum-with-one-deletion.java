/*
https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

对比如果不删除，找和最大的subarray
public int maxSubArray(int[] nums) {
    int res = Integer.MIN_VALUE, curSum = 0;
    for (int num : nums) {
        curSum = Math.max(num, curSum + num);
        res = Math.max(res, curSum);
    }
    return res;
}

这里curSum就是noDelete，即从始至终都不删除，但如果某一个位置不删除还不如重启subarray来的大，那就重启
因为还要考虑在任意位置可以删除一个元素，那需要看删掉哪个会使得subarray和最大
而每个位置的res即为删与不删的大者
对于任一位置i，如果不删它，那就是之前的deleteOne+arr[i]，如果删它，即为上一步的noDelete
这里的不删它指的是之前已经删除过了一个，所以此时要加上当前的元素
之前没删过且加上当前元素的情况其实就是noDelete的情况，所以不需要在deleteOne中考虑了

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length, deleteOne = 0, noDelete = arr[0], res = arr[0];
        for (int i = 1; i < n; i++) {
            deleteOne = Math.max(noDelete, deleteOne + arr[i]);
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            res = Math.max(Math.max(deleteOne, noDelete), res);
        }
        return res;
    }
}