class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        num_to_count = {}
        for num in nums:
            if num in num_to_count:
                return num
            num_to_count[num] = 1
        return -1
        