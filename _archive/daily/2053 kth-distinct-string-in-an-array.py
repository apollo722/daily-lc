'''
https://leetcode.com/problems/kth-distinct-string-in-an-array/

代码题

Time: O(n)
Space: O(n)
'''

class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        m = {}
        for num in arr:
            if num not in m:
                m[num] = 0
            m[num] += 1
        for num in arr:
            if m[num] == 1:
                k -= 1
            if k == 0:
                return num
        return ""
        