/*
https://leetcode.com/problems/word-ladder/

BFS模板

Time: O(mn)，n为单词个数，m为input单词长度，这里没有算语言内部从arr生成str的耗时，否则要再乘m
Space: O(n)，q里最多装n个单词
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>(wordList);
        if (!visited.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.remove(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                char[] cArr = cur.toCharArray();
                for (int i = 0; i < cArr.length; i++) {
                    char ori = cArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ori == c) continue;
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