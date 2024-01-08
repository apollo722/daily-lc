/*
https://leetcode.com/problems/increasing-triplet-subsequence/

按顺序找到三个数即可，即先找最小的，再找中间的，最后如果有大于中间的数即为true
选择过程中尽量要两个较小的数越小越好，所以类似找min1，min2的思路

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int numI = Integer.MAX_VALUE, numJ = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < numI) numI = num;
            else if (num > numI && num < numJ) numJ = num;
            else if (num > numJ) return true;
        }
        return false;
    }
}