'''
https://leetcode.com/problems/maximum-total-importance-of-roads/

城市连接的道路越多，就越该把更大的数assign给它
所以计算入度，之后排序，累加即可

Time: O(nlogn)
Space: O(n)
'''

class Solution:
    def maximumImportance(self, n: int, roads: List[List[int]]) -> int:
        indegree = [0] * n
        for e in roads:
            indegree[e[0]] += 1
            indegree[e[1]] += 1
        indegree.sort(reverse=True)
        res = 0
        for cnt in indegree:
            res += n * cnt
            n -= 1
        return res
