/*
https://leetcode.com/problems/3sum/

排序后的kSum，注意去重

Time: O(n^2)
Space: O(logn)，考虑排序的space开销
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 3, 0, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int k, int l, int tar) {
        if (k == 2) return twoSum(nums, l, tar);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = l; i < nums.length && nums[i] <= 0; i++) {
            if (i > l && nums[i - 1] == nums[i]) continue;
            for (List<Integer> list : kSum(nums, k - 1, i + 1, tar - nums[i])) {
                if (list.size() == 0) continue;
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int l, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        int i = l, j = nums.length - 1;
        while (i < j) {
            if ((j < nums.length - 1 && nums[j + 1] == nums[j]) || nums[i] + nums[j] > tar) j--;
            else if ((i > l && nums[i - 1] == nums[i]) || nums[i] + nums[j] < tar) i++;
            else {
                List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j]));
                res.add(list);
                i++;
                j--;
            }
        }
        return res;
    }
}