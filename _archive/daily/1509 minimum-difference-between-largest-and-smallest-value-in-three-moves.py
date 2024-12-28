'''
https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

题目相当于移除三个数字，之后剩下的数字里最大最小的差值是什么
移除哪三个呢？肯定是从极值里面找，要么移除三个最大的，要么三个最小的
要么两个最大的一个最小的，要么两个最小的一个最大的
这四种情况里必然有解

那么找到最小的和最大的四个数，之后反别做差，差最小的就是答案了
这是因为移除掉三个数之后，剩下的最大与最小值的差就是解答，那么干脆直接找到最大和最小的四个数
并把它们所有可能的情况找到即可

可以只排前四或者后四，利用heap，这样可以nlog4，而不是nlogn

Time: O(n)
Space: O(1)
'''

class Solution:
    def minDifference(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 4:
            return 0

        small4 = sorted(heapq.nsmallest(4, nums))
        large4 = sorted(heapq.nlargest(4, nums))
        res = float("inf")
        for i in range(4):
            res = min(res, large4[i] - small4[i])

        return res
