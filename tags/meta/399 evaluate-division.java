/*
https://leetcode.com/problems/evaluate-division/

等于是图里找两个点路径的累计权重，只是计算方式是乘积
一开始要先建立带权重的双向图，即u->v值是w，v->u值是1/w
之后dfs找路径，每次把权重乘到当前累积权重上
如果到最后没有找到返回-1.0
每次找下一个节点时只需要看是否找到一个即可，即只要dfs中res不为-1.0，即找到了路径
那么就可以直接break返回，因为题目保证不会有矛盾的情况，找到了返回即可提前剪枝

Time: O(mn)，m为number of queries，n为number of equations
Space: O(n)
*/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair<String, Double>>> g = new HashMap<>();
        int idx = 0;
        for(List<String> equation : equations) {
            double value = values[idx++];
            String u = equation.get(0), v = equation.get(1);
            if (!g.containsKey(u)) g.put(u, new ArrayList<>());
            if (!g.containsKey(v)) g.put(v, new ArrayList<>());
            g.get(u).add(new Pair(v, value));
            g.get(v).add(new Pair(u, 1.0 / value));
        }
        double[] res = new double[queries.size()];
        idx = 0;
        for (List<String> query : queries) {
            res[idx++] = dfs(1.0, query.get(0), query.get(1), g, new HashSet<>());
        }
        return res;
    }

    private double dfs(double prod, String s, String t, HashMap<String, List<Pair<String, Double>>> g, HashSet<String> set) {
        if (!g.containsKey(s) || !g.containsKey(t)) return -1.0;
        if (s.equals(t)) return prod;
        set.add(s);
        double res = -1.0;
        for (Pair<String, Double> p : g.get(s)) {
            Double v = p.getValue();
            String next = p.getKey();
            if (!set.contains(next)) {
                res = dfs(prod * v, next, t, g, set);
                if (res != -1.0) return res;
            }
        }
        return res;
    }
}