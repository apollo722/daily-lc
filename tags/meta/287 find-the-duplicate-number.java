/*
https://leetcode.com/problems/find-the-duplicate-number/

对于constant space的算法来说，有下面两种比较好想
1. O(nlogn)时间
对于[1,n]的数组来说，如果没有重复，那么任意一个元素i，数组中小于等于它元素的数量应该是exactly i个
如果小于等于i的元素大于了i个，证明i或i之前有重复元素，否则个数等于i的话，重复元素一定比i更大
所以可以二分查找[1,n]的元素，每找一个查一下有多少元素小于等于它，并进行二分即可

2. O(n)时间
虽然题目要求不能更改原数组，但是利用数组的idx map数字的思想还是可以用的
因为范围是[1,n]，所以每一个数字都可以对应到数组的一个idx上
因为有一个重复元素，所以如果不断的走nums[nums[i]]的话一定有一个时间点会走到同样的元素
即相当于有了环，所以思路如同探测环的起点一样，用slow和fast两个ptr来走nums[nums[i]]
因为存在环，fast一定会和slow在某处相遇，相遇的时候重置fast，再次相遇的点即是环的交点，即为答案

Time: O(n)
Space: O(1)
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        int res = nums[0];
        while (slow != res) {
            slow = nums[slow];
            res = nums[res];
        }
        return res;
    }
}