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


/*
BFS变种，带层序遍历的BFS。
每个单词往下走都要遍历所有位置，并对每个位置遍历每种字符替换。
这些变化都是在同一层发生的，并不会增加step，所以需要用层序遍历的做法把他们放在同一层入队。
*/