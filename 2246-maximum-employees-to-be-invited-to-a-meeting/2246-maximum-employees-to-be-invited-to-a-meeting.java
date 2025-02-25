class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.addLast(i);
        }
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            int next = favorite[cur];
            depth[next] = Math.max(depth[next], depth[cur] + 1);
            if (--indegree[next] == 0) q.addLast(next);
        }
        
        int maxCycle = 0, couple = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) continue;
            int cycleLen = 0, cur = i;
            while (indegree[cur] != 0) {
                indegree[cur] = 0;
                cycleLen++;
                cur = favorite[cur];
            }
            if (cycleLen == 2) {
                couple += depth[i] + depth[favorite[i]];
            } else maxCycle = Math.max(maxCycle, cycleLen);
        }
        int maxLen = 0;
        return Math.max(maxCycle, couple);
    }
}


/*
直观的想如果一群人围成了一个圈，那么这一圈人肯定可以都被邀请，且没办法再加新的人了。
所以最大的圈可能是答案。
如果是没有圈，即一条大直线，实际上是不能形成答案的，也不合法，因为最后一个人一定得喜欢一个人，必然要形成环。
比较复杂的情况是如果两个人形成的环，之后每个人还有一条或者多条尾巴，那么最长的情况是两个人各自最长的深度加和。
如果有很多个这种以两人环为中心形成的结构，那么他们都可以坐到一起。比如C->A<->B<-D和C1->A1<->B1<-D1是可以都参会的。
这里有几个隐藏的条件，即每个人最多只会有一个favorite，所以不会有A<->B<->C的情况。
处理题目变成了：
1. 寻找不在环上的点，并把每个节点的深度标上；
2. 寻找长度非2的环，分别计算两个节点的最长深度的和；
3. 寻找长度大于2的环，记录上最大的长度。

情况1可以直接用拓扑排序，从入度为0的地方逐个深入的向下找，每次找到的节点都取其上游节点+1与它目前深度的较大者。
接下来剩下入度不为0的就一定在环里。
如果环的长度是2，就把节点的深度都加上。否则，更新最大环长。
最后的结果就是看各种情况的最大值。
*/