class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) res[l++] = nums[i];
            if (nums[j] > pivot) res[r--] = nums[j];
        }
        while (l <= r) {
            res[l++] = pivot;
        }
        return res;
    }
}


/*
乍一看像是quick select，但实际上partition之后元素都要保持原有的顺序，就不能用quick select。
最简单的想法就是创建一个结果数组，之后分别正向以及逆向扫一遍数组，分别将比pivot小和大的元素都放到结果数组的首尾。
剩下的部分全用pivot填充。这样要正反扫两边数组。
再优化一点点就是正反向同时扫，在一个循环里分别处理首尾。因为是分别处理大于和小于pivot的部分，所以不会相互干扰。
最后再处理中间的相等部分。
本题应该是没有办法不用额外的空间来解决，因为没有办法不破坏原有的顺序。
*/