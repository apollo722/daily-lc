'''
https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/

拓扑排序模板
先拓扑排序，按照拓扑序构造结果，最后在排序

Time: O(v^2 logv + e)
Space: O(v^2 + e)
'''

class Solution:
    def getAncestors(self, n, edges):
        g = [[] for _ in range(n)]
        indegree = [0 for _ in range(n)]
        for e in edges:
            u = e[0]
            v = e[1]
            g[u].append(v)
            indegree[v] += 1

        q = [i for i in range(n) if indegree[i] == 0]

        order = []
        while q:
            cur = q.pop(0)
            order.append(cur)

            for next in g[cur]:
                indegree[next] -= 1
                if indegree[next] == 0:
                    q.append(next)

        res = [[] for _ in range(n)]
        set_list = [set() for _ in range(n)]

        for cur in order:
            for next in g[cur]:
                set_list[next].add(cur)
                set_list[next].update(set_list[cur])

        for i in range(n):
            res[i].extend(set_list[i])
            res[i].sort()

        return res