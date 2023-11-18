/*
https://leetcode.com/problems/frequency-of-the-most-frequent-element/

sliding window
找到最长的window，使得window中所有数字都变成window最右侧的数字
此时需要的operation即为window最右数字*window大小
如果此时需要的operation <= k即为valid window
否则就要缩小窗口左端点

当window不valid时，只需要缩小左端点1格即可，因为并不需要在意什么时候window才会变成valid
因为之前一个valid的状态已经固定了window的size
保持这个size到终点，或者终点之前增加size都可以获得答案
减少size并不会使答案更新

注意，答案并不是选定一个数字使小于它的数字都变成它
而是选定一个数字，使小于并离它最近的数字都变成它
比如 1 10 10 10 10，k = 1
如果所有小于target的数字都变成target，那答案只能是1
但正确答案是4，因为是变化离它最近的数字，可以不消耗完k

Time: O(nlogn)
Space: O(1) (not counting space needed by sorting the array)
*/

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        long curSum = 0;
        while (r < nums.length) {
            int tar = nums[r];
            curSum += tar;
            if ((r - l + 1) * tar - curSum > k) {
                curSum -= nums[l];
                l++;
            }
            r++;
        }
        return nums.length - l;
    }
}