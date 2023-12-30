/*
https://leetcode.com/problems/make-sum-divisible-by-p/

先统计数组总和，注意要用long型防止和过大
如果总和能被p整除，直接返回0，否则要找的就是长度最小的和为remainder=sum%p的数组
这就回到了two sum的问题，用map记录每个位置的和对p余数
假设localSum是子数组和，记它对p的余数为curRemainder=localSum%p
因为要找和对p余数为remainder的子数组，而当前和对p余数为curRemainder
所以只要存在curRemainder-remainder，或curRemainder本身就是remainder，即证明当前段和对p余数为remainder
记tar=curRemainder-remainder，每次在map中搜索它即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) sum += num;
        if (sum % p == 0) return 0;
        int remainder = (int)(sum % p), n = nums.length, res = n;
        long localSum = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            localSum += nums[i];
            int curRemainder = (int)(localSum % p), tar = curRemainder - remainder;
            if (tar < 0) tar += p;
            if (curRemainder == remainder) res = Math.min(res, i + 1);
            if (m.containsKey(tar)) res = Math.min(res, i - m.get(tar));
            m.put(curRemainder, i);
        }
        return res == n ? -1 : res;
    }
}