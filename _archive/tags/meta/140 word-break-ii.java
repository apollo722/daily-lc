/*
https://leetcode.com/problems/word-break-ii/

memo dp
对于任何长度为n的str，总共可以有n个分割的点，即n个prefix
对于每个prefix形成的word，如果在input list中存在
那么就看后续process能不能走到底
如果走的到，就一层层叠加word即可

为什么s.length() == 0时必须是null而不是empty list呢？因为如下写法会产生如下的memo map：
"catsanddog"/["cat","cats","and","sand","dog"]
memo: {anddog=[and dog], sanddog=[sand dog], dog=[dog], catsanddog=[cat sand dog, cats and dog]}

"catsandog"/["cats","dog","sand","and","cat"]
{catsandog=[], andog=[], og=[], sandog=[]}

最后不论如何都将res放到memo了，所以如果只return empty list会无法区分是走到了底还是因为没有组成valid str而为空的
所以需要用return null的方式来区分一个valid的组成走到了底，而不能用empty list

Time: ?
Space: ?
*/

class Solution {
    HashMap<String, List<String>> memo = new HashMap<>();
    HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return solve(s);
    }

    private List<String> solve(String s) {
        if (s.length() == 0) return null;
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String curWord = s.substring(0, i + 1);
            if (set.contains(curWord)) {
                List<String> resList = solve(s.substring(i + 1));
                if (resList == null) res.add(curWord);
                else {
                    for (String r : resList) {
                        res.add(curWord + " " + r);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}