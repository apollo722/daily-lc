/*
https://leetcode.com/problems/k-th-smallest-prime-fraction/

用pq来存储前k个数对
每次把分母更大一点的入列
pq排序即a0/a1 - b0/b1 -> a0b1 - b0a1

Time: O((n + k)logn)
Space: O(n)
*/

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);
        for (int i = 1; i < arr.length; i++) {
            pq.add(new int[]{0, i});
        }
        while (--k > 0) {
            int[] cur = pq.poll();
            if (++cur[0] < cur[1]) pq.add(cur);
        }
        int[] res = pq.poll();
        return new int[]{arr[res[0]], arr[res[1]]};
    }
}