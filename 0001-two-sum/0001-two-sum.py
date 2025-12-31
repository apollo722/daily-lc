class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visited = defaultdict(int)
        for i in range(len(nums)):
            if target - nums[i] in visited:
                return [visited[target - nums[i]], i]
            else:
                visited[nums[i]] = i
        