/*
https://leetcode.com/problems/find-players-with-zero-or-one-losses/

因为编号有上限，所以可以用counting sort，否则用treemap即可
初始化map全为-1，如果编号出现为winner，置为0，出现为loser，出现过的编号就++，否则置为1

Time: O(n)
Space: O(max)
*/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] m = new int[100001];
        Arrays.fill(m, -1);
        for (int[] match : matches) {
            int w = match[0], l = match[1];
            if (m[w] == -1) m[w] = 0;
            if (m[l] == -1) m[l] = 1;
            else m[l]++;
        }
        List<Integer> res1 = new ArrayList<>(), res2 = new ArrayList<>();
        for (int i = 1; i < m.length; i++) {
            if (m[i] == 0) res1.add(i);
            else if (m[i] == 1) res2.add(i);
        }
        List<List<Integer>> res = Arrays.asList(res1, res2);
        return res;
    }
}