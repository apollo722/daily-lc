'''
https://leetcode.com/problems/magnetic-force-between-two-balls/

sliding window
计算一下每个minutes窗口的不开心顾客数量，找最大的那个窗口
之后再把所有本来就开心的顾客计算一下
加一起即可

Time: O(n)
Space: O(1)
'''

class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        n = len(customers)
        res = 0
        unreal_cus = 0
        for i in range(minutes):
            unreal_cus += customers[i] * grumpy[i]
        res = unreal_cus
        for i in range(minutes, n):
            unreal_cus += customers[i] * grumpy[i]
            unreal_cus -= customers[i - minutes] * grumpy[i - minutes]
            res = max(unreal_cus, res)

        for i in range(n):
            res += customers[i] * (1 - grumpy[i])

        return res