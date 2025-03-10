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
            for (; j < cur.length(); j++) {
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
        Deque<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) q.add(e.getKey());
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            res.append(cur);
            for (char next : g.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.add(next);
            }
        }
        return res.length() == g.size() ? res.toString() : "";
    }
}