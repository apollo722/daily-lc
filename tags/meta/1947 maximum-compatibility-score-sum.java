/*
https://leetcode.com/problems/maximum-compatibility-score-sum/

一开始想的是排序或者用trie以greedy形式找到最match的，后来发现这样做并不对，贪心并不能保证globally correct
所以只能枚举每一种可能性，也就是传统backtrack，这样做复杂度是O(n!m)，其中n是student人数，m是问卷长度

如果利用memo来记住每一种状态，则复杂度为O(n^2 2^n m)，空间复杂度为O(n 2^n)
在n很大时记忆数组更优化
因为题目中n很小，所以可以用bitmask来记录已经算过的情况

Time: O(n!m)
Space: O(n)，n为recursion stack最大深度

Time: O(n^2 2^n m)，记忆数组是n 2^n，而每个student都要考虑n种情况，故为n^2 2^n
Space: O(n 2^n)，n为recursion stack最大深度
*/

class Solution {
    int res = 0;
    int n = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        n = students.length;
        boolean[] visited = new boolean[n];
        backtrack(students, mentors, visited, 0, 0);
        return res;
    }

    private void backtrack(int[][] students, int[][] mentors, boolean[] visited, int idx, int cur) {
        if (idx >= 0) {
            res = Math.max(res, cur);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(students, mentors, visited, idx + 1, cur + calc(students[idx], mentors[i]));
                visited[i] = false;
            }
        }
    }

    private int calc(int[] a, int[] b) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) res++;
        }
        return res;
    }
}

class Solution {
    int[][] memo;
    int n;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        n = students.length;
        memo = new int[n][1 << n];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return solve(students, mentors, 0, 0);
    }

    private int solve(int[][] students, int[][] mentors, int idx, int mask) {
        if (idx == n) return 0;
        if (memo[idx][mask] >= 0) return memo[idx][mask];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                int cur = calc(students[idx], mentors[i]);
                cur += solve(students, mentors, idx + 1, mask | (1 << i));
                res = Math.max(res, cur);
            }
        }
        memo[idx][mask] = res;
        return res;
    }

    private int calc(int[] a, int[] b) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) res++;
        }
        return res;
    }
}