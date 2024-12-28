/*
https://leetcode.com/problems/words-within-two-edits-of-dictionary/

brutal force直接求解

Time: O(mnk)，m为queries length，n为dictionary length，k是word length
Space: O(1)
*/

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String q : queries) {
            int n = q.length();
            for (String s : dictionary) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (q.charAt(i) != s.charAt(i)) cnt++;
                    if (cnt > 2) break;
                }
                if (cnt <= 2) {
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}