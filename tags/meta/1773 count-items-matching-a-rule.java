/*
https://leetcode.com/problems/count-items-matching-a-rule/

什么样的运气能在面试中随机到这样的题呢？

Time: O(n)
Space: O(1)
*/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = -1, res = 0;
        if (ruleKey.equals("type")) idx = 0;
        else if (ruleKey.equals("color")) idx = 1;
        else idx = 2;
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) res++;
        }
        return res;
    }
}