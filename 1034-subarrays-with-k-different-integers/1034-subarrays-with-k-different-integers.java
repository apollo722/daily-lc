class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        System.out.println(solve(nums, k));
        return solve(nums, k) - solve(nums, k - 1);
    }

    private int solve(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int l = 0, r = 0, n = nums.length, cnt = 0, res = 0;
        while (r < n) {
            int cur = nums[r++];
            m.put(cur, m.getOrDefault(cur, 0) + 1);
            while (k < m.size()) {
                int left = nums[l++];
                m.put(left, m.get(left) - 1);
                if (m.get(left) == 0) m.remove(left);
            }
            res += r - l;
        }
        return res;
    }
}


/*
一个需要记住的解法就是把问题转化成at most k，之后求差。
比如exact k会比较难做，但如果是at most k那就转化成了之前做过的滑动窗口问题。
而exact k就是at most k与at most k-1的差值。
换成at most k之后就是常规的滑动窗口解法。
*/