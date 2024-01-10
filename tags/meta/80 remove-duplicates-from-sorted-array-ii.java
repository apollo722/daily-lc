/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

一步步想就是每次记录前一个元素的值，之后找cnt，如果小于等于2就放到数组前面，之后继续
否则继续找
如果和前面的元素不同了，证明换了一个元素，重新计数cnt即可
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, cnt = 1, cur = 1, prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == prev) {
                cnt++;
                if (cnt <= 2) nums[cur++] = nums[i];
            } else {
                cnt = 1;
                nums[cur++] = nums[i];
                prev = nums[i];
            }
        }
        return cur;
    }
}

更简洁的写法即每次查看和前一个是否相同，相同的就cnt++，不同的就重新计数
只有cnt<=2的时候会置换到数组前面

Time: O(n)
Space: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, cnt = 1, cur = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else cnt = 1;
            if (cnt <= 2) nums[cur++] = nums[i];
        }
        return cur;
    }
}