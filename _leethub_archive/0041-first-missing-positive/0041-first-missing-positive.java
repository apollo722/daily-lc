class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == i) continue;
            while (nums[i] - 1 >= 0 && nums[i] - 1 < n && nums[i] != nums[nums[i] - 1]) {
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
利用数组本身作为存储来存idx+1和值相同的元素，这样最后扫描的时候遇到的第一个与idx不符的位置的idx就是答案。
如果都符合，那么数组长度n就是答案。
对于明显不在数组范围的元素，比如负数，0，和大于数组长度的元素直接忽略即可，等其它应该在该位置的元素与其替换。
循环替换的时候要注意如果即将替换的元素和当前元素相同，实际上是不需要继续的。
所以有这个条件nums[i] != nums[nums[i] - 1]，来避免死循环例如[1,1]的情况。
这个条件还隐含了nums[i]-1 != i的情况，一石二鸟。
*/