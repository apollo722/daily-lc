class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> increaseList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (increaseList.size() == 0 || increaseList.get(increaseList.size() - 1) < cur) {
                increaseList.add(cur);
            } else {
                int idx = findFirstLarge(increaseList, cur);
                if (idx != -1) increaseList.set(idx, cur);
            }
        }
        return increaseList.size();
    }

    private int findFirstLarge(List<Integer> arr, int tar) {
        int l = 0, r = arr.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = arr.get(mid);
            if (cur < tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}


/*
递增序列顾名思义就是递增的。怎么样让它尽可能长呢？
每一个入队的数在满足递增的大条件下都尽可能的小，这样会让后面的数字有更多机会被包括进来组成更长的队列。
所以维持一个递增的list，每次遇到一个数字，如果它比队列最大的即末尾的数字还大，那它可以入队。
如果它比队列最大的数字小，证明它如果进入队列里的话，可以使得队列保持增序，但整体均值更小了，也就是有更大机会吸纳更多大一些的数字。
所以它应该替换掉队列里的一个数字。这里不是插入而是替换是因为不能更改队列元素的相对顺序，所以要替换。
替换谁呢？为了满足增序，被替换数字的前一个要比它小，后一个要比它大。而且还要尽可能的让它的位置尽量靠左。
也就是说找到第一个严格大于目标的位置。
那么就利用二分查找，找到第一个严格大于目标的位置，再进行替换即可。
*/