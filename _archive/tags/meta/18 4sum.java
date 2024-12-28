/*
https://leetcode.com/problems/4sum/

排序后的kSum，注意去重，注意元素加和可能超过int max，所以tar要设置成long
可以计算出当前需要的avg = tar / k，之后比较第一个和最后一个元素与avg的关系进而快速判断当前tar是否可以被得到

Time: O(n^(k-1))，本题k为4，即O(n^3)
Space: O(n)，因为有recursion，最多可以递归k，即n次，本题只算排序的space开销，即为O(logn)
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, 0, target);
    }

    private List<List<Integer>> kSum(int[] nums, int k, int l, long tar) {
        long avg = tar / k;
        if (l >= nums.length || nums[l] > avg || nums[nums.length - 1] < avg) return new ArrayList<>();
        if (k == 2) return twoSum(nums, l, tar);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = l; i < nums.length; i++) {
            if (i > l && nums[i - 1] == nums[i]) continue;
            for (List<Integer> list : kSum(nums, k - 1, i + 1, tar - nums[i])) {
                if (list.size() == 0) continue;
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int l, long tar) {
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