class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        n = len(nums) // 2
        num_to_count = {}
        for num in nums:
            if num in num_to_count:
                num_to_count[num] += 1
                if num_to_count[num] == n:
                    return num
            else:
                num_to_count[num] = 1
        return -1
        