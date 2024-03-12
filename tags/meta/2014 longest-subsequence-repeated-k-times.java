/*
https://leetcode.com/problems/longest-subsequence-repeated-k-times/

暴力BFS求解
先求出所有频率大于等于k的字符，这些是可能组成结果的字符
之后每一个字符都可能向后组成重复k次的结果，那么就依次放入q中暴力检索
因为是按字母顺序的检查越来越长的字符串，最后满足条件的自然就是结果

Time: O(26^(n/k) n)，最长结果即n/k，每个位置有26种选择，每个位置要check是否在s中存在k次，即需要O(n)时间
Space: O(26^(n/k))
*/

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res = "";
        int[] m = new int[26];
        for (char c : s.toCharArray()) {
            m[c - 'a']++;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (m[i] >= k) list.add((char)('a' + i));
        }
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (char c : list) {
                String next = cur + c;
                if (check(s, next, k)) {
                    q.add(next);
                    res = next;
                }
            }
        }
        return res;
    }

    private boolean check(String s, String cur, int k) {
        int j = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != cur.charAt(j)) continue;
            j++;
            if (j == cur.length()) {
                cnt++;
                j = 0;
                if (cnt == k) return true;
            }
        }
        return false;
    }
}