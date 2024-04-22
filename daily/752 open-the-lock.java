/*
https://leetcode.com/problems/open-the-lock/

BFS模板
和word ladder一样，要注意一步是旋转一个位置
所以相当于每次出q要么+1要么-1

Time: O(4(n + 10^4))
Space: O(4(n + 10^4))
*/

class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Queue<String> q = new LinkedList<>();   
        HashSet<String> visited = new HashSet<>();
        for (String s : deadends) visited.add(s);
        if (visited.contains("0000")) return -1;
        q.add("0000");
        visited.add("0000");
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    char[] arr = cur.toCharArray();
                    int c = arr[i] - '0';
                    for (int j= -1; j <= 1; j += 2) {
                        int nc = c + j;
                        if (nc < 0) nc = 9;
                        else if (nc > 9) nc = 0;
                        arr[i] = (char)(nc + '0');
                        String next = new String(arr);
                        if (next.equals(target)) return res;
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                        arr[i] = (char)(c + '0');
                    }
                }
            }
        }
        return -1;
    }
}