class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>(wordList);
        int res = 1;
        if (!visited.contains(endWord)) return 0;
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        visited.remove(beginWord);
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                char[] cArr = cur.toCharArray();
                for (int i = 0; i < cArr.length; i++) {
                    char ori = cArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ori) continue;
                        cArr[i] = c;
                        String next = new String(cArr);
                        if (visited.contains(next)) {
                            if (next.equals(endWord)) return res;
                            q.add(next);
                            visited.remove(next);
                        }
                        cArr[i] = ori;
                    }
                }
            }
        }
        return 0;
    }
}