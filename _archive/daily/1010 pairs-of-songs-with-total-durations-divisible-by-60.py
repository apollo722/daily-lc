'''
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

two sum变种，注意一下60和0的情况，要直接判断其本身而不是60-余数

Time: O(n)
Space: O(1)
'''

class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        m = collections.defaultdict(int)
        res = 0
        for t in time:
            if t % 60 == 0:
                res += m[0]
            else:
                res += m[60 - t % 60]
            m[t % 60] += 1
        return res