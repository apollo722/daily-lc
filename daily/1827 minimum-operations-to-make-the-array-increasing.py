'''
https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

代码题

Time: O(n)
Space: O(1)
'''

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        res = 0
        prev = nums[0]
        for i in range(1, len(nums)):
            if nums[i] <= prev:
                res += prev + 1 - nums[i]
                prev = prev + 1
            else:
                prev = nums[i]
        return res