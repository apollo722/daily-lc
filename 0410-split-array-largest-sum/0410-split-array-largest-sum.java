class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, res = 0;
        for (int num : nums) r += num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = countGroup(nums, mid, k);
            if (cur > k) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    private int countGroup(int[] nums, int sum, int k) {
        int curSum = 0, res = 1;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > sum) {
                res++;
                curSum = 0;
                i--;
            }
            if (res > k) return k + 1;
        }
        return res;
    }
}


/*
如果答案过于小，那么能分的组数就会很多，不满足k的要求。
如果答案过于大，倒是可以满足要求，但题目要求找到尽可能小的答案。
所以就可以转化成二分查找。给定一个数，看看如果尽量的把每个组的和都尽量和它靠近，能形成多少组。
如果形成的组太多，说明这个数太小了，要右移。
如果形成的组数小于或者等于k，那有可能是答案，因为尽量挤着分组了。题目要求找最小，那就左移看看能不能再挤挤。
*/