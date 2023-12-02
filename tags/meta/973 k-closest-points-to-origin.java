/*
https://leetcode.com/problems/k-closest-points-to-origin/

标准partition快排算法

Time: O(n)，如果随机较差，最坏可能O(n^2)
Space: O(n)
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int idx = partition(points, l, r);
            if (idx == k - 1) {
                int[][] res = new int[k][2];
                for (int i = 0; i < k; i++) res[i] = points[i];
                return res;
            }
            else if (idx < k) l = idx + 1;
            else r = idx - 1;
        }
        return null;
    }

    private int partition(int[][] points, int start, int end) {
        if (start >= end) return start;
        int rIdx = new Random().nextInt(end - start + 1) + start;
        swap(points, start, rIdx);
        int pDist = calc(points[start]);
        int l = start, r = end + 1;
        while (l <= r) {
            while (calc(points[++l]) < pDist) if (l >= end) break;
            while (calc(points[--r]) > pDist) if (r <= start) break;
            if (l >= r) break;
            swap(points, l, r);
        }
        swap(points, start, r);
        return r;
    }

    private void swap(int[][] p, int a, int b) {
        int[] t = p[a];
        p[a] = p[b];
        p[b] = t;
    }

    private int calc(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}