/*
https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/

用pq存储所有元素和idx的pair，并且记录哪个元素被标记与否
每次检查标记，如果被标记过那直接找到k个最小值，并分别检查它们是否被标记过
一旦没被标记，那么要从当前的总和中减去
最后每一轮剩下的和就是当时未被标记元素的总和

Time: O(nlogn)，n为queries长度，假设n大于nums长度
Space: O(n)
*/

class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        long sum = 0;
        int i = 0;
        for (int num : nums) {
            sum += num;
            pq.add(new int[]{num, i++});
        }
        boolean[] marked = new boolean[nums.length];
        long[] res = new long[queries.length];
        int p = 0;
        for (int[] q : queries) {
            int idx = q[0], k = q[1];
            if (!marked[idx]) {
                marked[idx] = true;
                sum -= nums[idx];
            }
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                int j = cur[1], val = cur[0];
                if (!marked[j]) {
                    marked[j] = true;
                    sum -= val;
                    k--;
                }
            }
            res[p++] = sum;
        }
        return res;
    }
}