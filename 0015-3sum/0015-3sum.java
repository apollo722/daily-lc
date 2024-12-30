class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 3, 0, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int k, int start, int tar) {
        if (k == 2) return twoSum(nums, start, tar);
        List<List<Integer>> res = new ArrayList<>();
        if (nums[start] > tar / k || nums[nums.length - 1] < tar / k) return res;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            for (List<Integer> list : kSum(nums, k - 1, i + 1, tar - nums[i])) {
                if (list.size() == 0) continue;
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        if (start >= nums.length || nums[start] > tar) return res;
        int l = start, r = nums.length - 1;
        while (l < r) {
            while (l < nums.length && l > start && nums[l] == nums[l - 1]) l++;
            while (r > start && r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
            if (l >= r) break;
            if (nums[l] + nums[r] == tar) {
                res.add(new ArrayList<>(Arrays.asList(nums[l], nums[r])));
                l++;
                r--;
            } else if (nums[l] + nums[r] < tar) l++;
            else r--;
        }
        return res;
    }
}