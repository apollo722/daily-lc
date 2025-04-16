/*
滑动窗口。
想一下，如果[i,j]满足条件，那么j从[j+1,n]必然都满足条件。
这就就变成了滑动窗口的问题。只需要找到每一个最小的满足k的窗口，那么窗口右侧有多少元素就能组成多少答案。
每次遇到一个元素，看看目前map中已经出现了多少个该元素。出现多少个，就能组成多少pair。
当满足条件时候，计算当前窗口右侧有多少种可能，加到结果中。
之后滑动左窗口。移除一个元素之后，该元素在map中剩下多少个次数，意味着移调它损失了多少pair。

Time: O(N)
Space: O(N)
*/

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        while (r < n) {
            int cur = nums[r];
            cnt += map.getOrDefault(cur, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (cnt >= k) {
                res += n - r;
                int left = nums[l];
                map.put(left, map.get(left) - 1);
                cnt -= map.get(left);
                l++;
            }
            r++;
        }
        return res;
    }
}