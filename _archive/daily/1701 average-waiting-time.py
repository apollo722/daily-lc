'''
https://leetcode.com/problems/average-waiting-time/

代码题，注意只能在顾客来了之后才能准备
所以要看当前时间和到来时间哪个更远

Time: O(n)
Space: O(1)
'''

class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        cur = customers[0][0]
        res = 0
        for c in customers:
            need = c[1]
            cur = max(cur, c[0])
            cur += need
            res += cur - c[0]
        return res / len(customers)
