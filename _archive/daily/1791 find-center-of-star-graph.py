'''
https://leetcode.com/problems/find-center-of-star-graph/

要么是(0,0)，要么是(0,1)
只要看这两个哪个不在其它的所有边中，另一个就是返回

Time: O(1)
Space: O(1)
'''

class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        can1 = edges[0][0]
        can2 = edges[0][1]
        for e in edges:
            if can1 not in e:
                return can2
        return can1