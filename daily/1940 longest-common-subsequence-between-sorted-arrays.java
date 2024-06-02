/*
https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/

二分查找，如果一个元素在所有行都出现，就加入结果
否则直接跳过查找下一个元素
最快就是先找到最短的行之后找

Time: O(mnlogn)
Space: O(1)
*/

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        int m = arrays.length, n = arrays[0].length;
        for (int i = 0; i < n; i++) {
            int cur = arrays[0][i];
            int cnt = 1;
            for (int j = 1; j < m; j++) {
                int[] arr = arrays[j];
                int idx = find(arr, cur);
                if (idx == -1) break;
                cnt++;
            }
            if (cnt == m) res.add(cur);
        }
        return res;
    }

    private int find(int[] arr, int tar) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}