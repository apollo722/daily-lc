/*
https://leetcode.com/problems/alien-dictionary/

拓扑排序模板，注意不可能形成图的情况，即前一个word和后一个word共享前缀，但前一个word更长
即：abcd -> abc

Time: O(v + e)，因为一开始扫描了所有str的所有字符，此部分为O(nk)，n为word个数，k为averge word长度
Space: O(v + e)，因为字母有限，所以也可以想作O(1)
*/

class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> g = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (!g.containsKey(c)) g.put(c, new ArrayList<>());
                if (!indegree.containsKey(c)) indegree.put(c, 0);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1], cur = words[i];
            int j = 0;
            for (j = 0; j < cur.length(); j++) {
                if (j >= prev.length()) break;
                char pc = prev.charAt(j), cc = cur.charAt(j);
                if (pc != cc) {
                    indegree.put(cc, indegree.get(cc) + 1);
                    g.get(pc).add(cc);
                    break;
                }
            }
            if (j == cur.length() && j < prev.length()) return "";
        }
        HashSet<Character> visited = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) q.add(e.getKey());
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            visited.add(cur);
            res.append(cur);
            for (char next : g.get(cur)) {
                if (visited.contains(next)) continue;
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.add(next);
            }
        }
        return res.length() == g.size() ? res.toString() : "";
    }
}