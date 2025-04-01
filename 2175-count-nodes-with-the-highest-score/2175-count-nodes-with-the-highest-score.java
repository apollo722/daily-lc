class Solution {
    long[] memo;
    int n;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        memo = new long[n];
        for (int i = 1; i < n; i++) {
            g.get(parents[i]).add(i);
        }
        dfs(g, 0);
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, memo[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (memo[i] == max) res++;
        }
        return res;
    }

    private long dfs(List<List<Integer>> g, int root) {
        long prod = 1, sum = 1;
        for (int next : g.get(root)) {
            long cnt = dfs(g, next);
            prod *= cnt;
            sum += cnt;
        }
        memo[root] = prod * (Math.max(1, n - sum));
        return sum;
    }
}