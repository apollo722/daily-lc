'''
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

sliding window变种
主要是要能快速知道区域内最大与最小值，且能在移动左边界时移除掉对应的值
所以维护两个单调栈，分别递增和递减
当入列右侧时，比它大/小的元素就不会对值有影响，可以pop出
移动左边界时，如果左边界恰好是栈首，那就移除掉即可

Time: O(n)
Space: O(n)
'''

class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        max_dq = deque()
        min_dq = deque()
        l = 0
        res = 0
        for r in range(len(nums)):
            while max_dq and max_dq[-1] < nums[r]:
                max_dq.pop()
            max_dq.append(nums[r])

            while min_dq and min_dq[-1] > nums[r]:
                min_dq.pop()
            min_dq.append(nums[r])

            while max_dq[0] - min_dq[0] > limit:
                if max_dq[0] == nums[l]:
                    max_dq.popleft()
                if min_dq[0] == nums[l]:
                    min_dq.popleft()
                l += 1
            res = max(res, r - l + 1)
        return res