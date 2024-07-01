'''
https://leetcode.com/problems/three-consecutive-odds/

代码题，检查所有长度为3的子数组即可

Time: O(n)
Space: O(1)
'''

class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        n = len(arr)
        if n < 3:
            return False
        for i in range(2, n):
            if arr[i] % 2 == 1 and arr[i - 1] % 2 == 1 and arr[i - 2] % 2 == 1:
                return True
        return False