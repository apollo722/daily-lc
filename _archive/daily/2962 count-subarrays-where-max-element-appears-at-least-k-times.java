/*
https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

sliding window模板，唯一的trick是怎么统计个数
其它都是传统sliding window，当k==cnt的时候移动左窗口
那么当跳出循环时，证明现在l的位置是恰好不满足条件的位置
那么0到l-1的idx即都是满足的，因为跳出循环的前一刻窗口里还至少有k个最大元素
那么0到l-1的范围内有多少个最大元素甚至没有，都可以满足了，那么直接把l个加入结果
意为以当前r为结尾，0到l-1的位置形成的子数组都至少含有k个最大值

Time: O(n)
Space: O(1)
*/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(num, max);
        long res = 0;
        int l = 0, r = 0, cnt = 0;
        while (r < nums.length) {
            int cur = nums[r];
            if (cur == max) cnt++;
            while (k == cnt) {
                if (nums[l] == max) cnt--;
                l++;
            }
            res += l;
            r++;
        }
        return res;
    }
}