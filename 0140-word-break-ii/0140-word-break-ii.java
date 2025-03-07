class Solution {
    HashSet<String> set;
    // HashMap<Integer, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return solve(s, 0);
    }

    private List<String> solve(String s, int idx) {
        if (idx == s.length()) return null;
        // if (memo.containsKey(idx)) return memo.get(idx);
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
        // memo.put(idx, res);
        return res;
    }
}


/*
递归+记忆。
扫描字符串每一个位置，形成前缀。如果前缀在字典里，求解剩下的部分。
如果剩下的部分有解，那么该前缀就可以放在它们前面，返回给上层。
因为递归求解的时候相同的前缀位置可能被重复计算多次，所以要记忆一下前缀位置和结果的对应，以便节省计算。
一个比较tricky的部分是，当前缀走到尽头的时候要返回成功，即寻找完成。这样告诉上层要把前缀单词加到结果。
比如当扫描到最后一个词的时候，如果成功了，要把这个单词加到结果中。但如果失败，即下一层没有形成合法结果，那上层的前缀就不能加。但如果找不到结果本身也是空list，这就分不清到底是因为找不到，还是成功了。
所以规定如果成功了，即idx到尽头了，返回null。看到下层是null的时候要把前缀加到结果中。
如果不是null，要么有值，说明成功，要么为空，说明下层找不到了。把找不到和成功用空和null区分开，才能正确的决定要不要加前缀到结果。
*/