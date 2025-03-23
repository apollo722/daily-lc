/*
https://leetcode.com/problems/max-consecutive-ones-iii/

优化sliding window模板
如果是1，就一直移动右边界，如果是0，就减少k
如果k小于0了，证明换无可换了，再移动左边界缩小窗口
左边界移动的过程中把转换过的0再加回给k
最后窗口会保持在最长的位置，即r-l

Time: O(n)
Space: O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] == 0) k--;
            if (k < 0) {
                if (nums[l++] == 0) k++;
            }
            r++;
        }
        return r - l;
    }
}

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] extendedNums = new int[2 * n];
        System.arraycopy(nums, 0, extendedNums, 0, n);
        System.arraycopy(nums, 0, extendedNums, n, n);

        int l = 0, r = 0;
        int maxLen = 0;

        while (r < 2 * n) {
            if (extendedNums[r] == 0) k--;
            if (k < 0) {
                if (extendedNums[l] == 0) k++;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return Math.min(maxLen, n); // 最大长度不会超过原数组长度
    }
}

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int maxLen = 0;

        while (r < n) {
            if (nums[r] == -1) {
                l = r + 1; // 遇到-1，移动左指针到r+1
                k = k; // 重置k，因为-1不能被翻转
            } else if (nums[r] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[l] == 0) k++;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
