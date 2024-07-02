'''
https://leetcode.com/problems/intersection-of-two-arrays-ii/

代码题，用map存储即可

Time: O(n)
Space: O(n)
'''

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = defaultdict(int)
        for num in nums1:
            m[num] += 1
        res = []
        for num in nums2:
            if m[num] > 0:
                res.append(num)
                m[num] -= 1
        return res