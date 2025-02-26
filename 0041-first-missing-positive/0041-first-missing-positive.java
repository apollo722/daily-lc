class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] - 1 >= 0 && nums[i] - 1 < n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}


/*
利用数组本身作为存储来存idx和值相同的元素，这样最后扫描的时候遇到的第一个与idx不符的位置的idx就是答案。
如果都符合，那么数组长度n就是答案。
对于明显不在数组范围的元素，比如负数，0，和大于数组长度的元素直接忽略即可，等其它应该在该位置的元素与其替换。
*/