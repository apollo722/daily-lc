'''
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/

最后满足条件的子数组一定是1的个数那么长
那么只需要检查每个1个数长度的子数组的0的个数即可
对于套圈情况，可以再查一遍0，也可以多查到n+k为止，k为1的个数

Time: O(n)
Space: O(n)
'''

class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        cnt1 = 0
        n = len(nums)
        for num in nums:
            if num == 1:
                cnt1 += 1
        cnt0 = n - cnt1
        l = 0
        r = 0
        cur0 = 0
        while r < cnt1:
            if nums[r] == 0:
                cur0 += 1
            r += 1
        res1 = cur0
        while r < n:
            if nums[r] == 0:
                cur0 += 1
            if nums[l] == 0:
                cur0 -= 1
            r += 1
            l += 1
            res1 = min(res1, cur0)
        
        l = 0
        r = 0
        cur1 = 0
        while r < cnt0:
            if nums[r] == 1:
                cur1 += 1
            r += 1
        res2 = cur1
        while r < n:
            if nums[r] == 1:
                cur1 += 1
            if nums[l] == 1:
                cur1 -= 1
            r += 1
            l += 1
            res2 = min(res2, cur1)
        return min(res1, res2)