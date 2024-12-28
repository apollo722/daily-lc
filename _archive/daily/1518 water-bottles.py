'''
https://leetcode.com/problems/water-bottles/

代码题，模拟统计即可

Time: O(log(n))
Space: O(1)
'''

class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        res = numBottles
        empty = numBottles
        while empty >= numExchange:
            numBottles = empty // numExchange
            remaining = empty % numExchange
            res += numBottles
            empty = numBottles + remaining
        return res