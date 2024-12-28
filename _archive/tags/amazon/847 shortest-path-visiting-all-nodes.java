/*
https://leetcode.com/problems/shortest-path-visiting-all-nodes/

BFS模板变种
最短路径，虽然是变种的最短路径，但也要想到BFS
如果从固定的任意一点出发，找需要多少步能探索完所有的点，要怎么算？
把它放到q中，之后根据链接图把没有访问过的点放入q中，直到所有的点都访问了，所需的步数就是结果
那么找到最短的，且可以从任何点出发，那就相当于可以把所有点当作起点，且每个点都有自己的map来记录从这个点出发有哪些点已经见过
因为题目中n很小，所以可以用mask来存储访问过的点
之后利用BFS，把所有初始的情况都放进q，传统BFS，最后所有点都访问过的时候，所得到的步数就是结果

Time: O(2^n n^2)
Space: O(2^n n)
*/

class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][endingMask];
        ArrayList<int[]> queue = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {i, 1 << i});
            seen[i][1 << i] = true;
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            ArrayList<int[]> nextQueue = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                int[] currentPair = queue.get(i);
                int node = currentPair[0];
                int mask = currentPair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endingMask) {
                        return steps;
                    }
                    
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        nextQueue.add(new int[] {neighbor, nextMask});
                    }
                }
            }
            
            queue = nextQueue;
        }
        
        return -1;
    }
}