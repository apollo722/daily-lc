/*
https://leetcode.com/problems/single-element-in-a-sorted-array/

题目中给定只有一个元素只出现一次，意味着整个数组长度一定为奇数
那么给定任何一个位置，如果这个位置为一个奇数idx，意味着包括它本身，前面总共有偶数个元素，即它后面有奇数个元素
由于二分查找的写法问题，mid可能等于l而不可能等于r，所以这里查询mid和mid+1的位置更好，因为不会越界
即如果mid位置是奇数，那么回退一个，check mid和mid+1，否则直接check mid和mid+1
这是因为我们想知道前面的偶数个元素中的最后两个是否相等，如果相等，证明前面的偶数个元素都成双对了，那么单独的元素一定在右侧
否则，则在r以左
如果用l<=r的写法，那么意味着循环内部要check l==r的情况
因为答案一定存在，所以l==r时候直接返回nums[l]即可

l<=r与l<r的写法区别就是看要再循环内还是外处理l==r的情况

如果此题写作l<r，将变为如下形式：
while (l < r) {
    int mid = l + (r - l) / 2;
    if (mid % 2 == 1) mid--;
    if (nums[mid] == nums[mid + 1]) l = mid + 2;
    else r = mid;
}
return nums[l];

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) mid--;
            if (l == r) return nums[l];
            if (nums[mid] == nums[mid + 1]) l = mid + 2;
            else r = mid;
        }
        return -1;
    }
}