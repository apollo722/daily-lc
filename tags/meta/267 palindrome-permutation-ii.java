/*
https://leetcode.com/problems/palindrome-permutation-ii/

backtracking模板
统计好每个字符出现的频率之后，每次-2放到strbuilder中，只到总数剩下0或1

Time: O((n/2 + 1)!)
Space: O(n)
*/

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        int[] m = new int[26];
        for (char c : s.toCharArray()) m[c - 'a']++;
        backtrack(m, new StringBuilder(), s.length());
        return res;
    }

    private void backtrack(int[] m, StringBuilder cur, int re) {
        if (re == 1 || re == 0) {
            StringBuilder tmp = new StringBuilder(cur);
            if (re == 1) {
                for (int i = 0; i < 26; i++) {
                    if (m[i] == 1) {
                        res.add(cur.toString() + (char)(i + 'a') + tmp.reverse().toString());
                    }
                }
            } else res.add(cur.toString() + tmp.reverse().toString());
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (m[i] >= 2) {
                m[i] -= 2;
                cur.append((char)(i + 'a'));
                backtrack(m, cur, re - 2);
                cur.deleteCharAt(cur.length() - 1);
                m[i] += 2;
            }
        }
    }
}