class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> getFactors(int n) {
        dfs(new ArrayList<>(), n, 2);
        return res;
    }

    public void dfs(List<Integer> list, int r, int start) {
        if (list.size() > 0) {
            List<Integer> c = new ArrayList<>(list);
            c.add(r);
            res.add(c);
        }
        for (int i = start; i * i <= r; i++) {
            if (r % i == 0) {
                list.add(i);
                dfs(list, r / i, i);
                list.remove(list.size() - 1);
            }
        }
    } 
}