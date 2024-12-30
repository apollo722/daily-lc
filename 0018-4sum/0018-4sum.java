class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, 0, target);
    }

    private List<List<Integer>> kSum(int[] nums, int k, int start, long tar) {
        if (k == 2) return twoSum(nums, start, tar);
        List<List<Integer>> res = new ArrayList<>();
        if (start >= nums.length || nums[start] > tar / k || nums[nums.length - 1] < tar / k) return res;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            for (List<Integer> list : kSum(nums, k - 1, i + 1, tar - nums[i])) {
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, long tar) {
        List<List<Integer>> res = new ArrayList<>();
        if (start >= nums.length) return res;
        int l = start, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > tar || (r < nums.length - 1 && nums[r + 1] == nums[r])) r--;
            else if (nums[l] + nums[r] < tar || (l > start && nums[l] == nums[l - 1])) l++;
            else {
                res.add(new ArrayList<>(Arrays.asList(nums[l], nums[r])));
                l++;
                r--;
            }
        }
        return res;
    }
}