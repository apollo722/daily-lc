class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 0));
        while (!pq.isEmpty() && k-- > 0) {
            int[] top = pq.poll();
            int i = top[1], j = top[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (i + 1 < m && !visited.contains(new Pair(i + 1, j))) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair(i + 1, j));
            }
            if (j + 1 < n && !visited.contains(new Pair(i, j + 1))) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair(i, j + 1));
            }
        }
        return res;
    }
}