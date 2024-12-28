/*
https://leetcode.com/problems/magnetic-force-between-two-balls/

二分查找看答案在哪里
为了greedy的放置，所以要排序一下，从小到大放即一定可以保证能放对

Time: O(nlognk/m)
Space: O(logn)
*/

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = 1000000000;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(position, mid, m)) {
                res = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return res;
    }

    private boolean check(int[] position, int tar, int m) {
        int prev = position[0], cnt = 1;
        for (int i = 1; i < position.length && cnt < m; i++) {
            int cur = position[i];
            if (cur - prev >= tar) {
                cnt++;
                prev = cur;
            }
        }
        return m == cnt;
    }
}