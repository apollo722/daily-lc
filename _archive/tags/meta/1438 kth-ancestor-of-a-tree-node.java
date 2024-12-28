/*
https://leetcode.com/problems/kth-ancestor-of-a-tree-node/

用到了一个新的解题思路叫做binary lifting，就是反向的二分
假如按部就班的找k个祖先，那么需要向上找k次
那么如果找第13个祖先，可以以二分的形式，假设已经知道了第8代，再找个第4，再找个第2，最后再向上1代，只需要4次就可以
所以对于第k代，把k的二进制表达为1的位数的祖先都找到就可以了
所以要先提前找到所有节点的第1，2，4，8等等祖先
当想找比如第8代的时候，可以先找第4代的第4代祖先，第4代可以先找第2代的第2代，而第2代其下一代
所以外层循环是总代数，内层循环是之前已经知道的上1层
都知道了之后，利用二分的思想查找就好
其中一个跳出的case是如果一个节点已经没有k代祖先，那么其一定也没有k+1代祖先
故初始可以都置于-1

Time: O(n)
Space: O(n)
*/

class TreeAncestor {
    int[][] memo;
    int p = 0;
    public TreeAncestor(int n, int[] parent) {
        p = (int)((Math.log(n) / Math.log(2)) + 1);
        memo = new int[n][p];
        for (int[] m : memo) Arrays.fill(m, -1);
        for (int i = 0; i < n; i++) {
            memo[i][0] = parent[i];
        }
        for (int j = 1; j < p; j++) {
            for (int i = 0; i < n; i++) {
                if (memo[i][j - 1] != -1)
                    memo[i][j] = memo[memo[i][j - 1]][j - 1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < p; i++) {
            if (((k >> i) & 1) == 1) node = memo[node][i];
            if (node == -1) break;
        }
        return node;
    }
}