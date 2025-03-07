class Solution {
    HashSet<String> set;
    HashMap<Integer, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return solve(s, 0);
    }

    private List<String> solve(String s, int idx) {
        if (idx == s.length()) return null;
        if (memo.containsKey(idx)) return memo.get(idx);
        List<String> res = new ArrayList<>();
        for (int i = idx + 1; i <= s.length(); i++) {
            String cur = s.substring(idx, i);
            if (set.contains(cur)) {
                List<String> remainList = solve(s, i);
                if (remainList == null) {
                    res.add(cur);
                    continue;
                }
                for (String str : remainList) {
                    res.add(cur + " " + str);
                }                   
            }
        }
        memo.put(idx, res);
        return res;
        
    }
}