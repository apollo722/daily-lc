/*
https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

先确定一下反转逻辑
如果一个数组[1,1,0,0,0,1]，遇到第一个0的时候，可以以它为起点反转k个，也可以找到一个包含它的范围来翻转
但思考一下，如果它不是反转的起始位置，那么势必会让它之前的某个1变成0，会造成额外的翻转，因为最终要翻回来
所以类似贪心，每次只要找到最左边的0，以它为起点开始翻转
如何知道某个位置已经被翻转了几次呢？对子数组的操作可以转化为对差分数组元素的操作
即diff[i]为i及其之后所有元素被翻转的次数
用变量记录当前的翻转次数，那么某个元素当前翻转的总次数即为flips+diff[i]
如果它是偶数，即没变化，否则相当于翻转了一次
当遇到0时，先翻转，即flips++，对于差分数组来说diff[i+k]-=1，相当于只对k范围内进行翻转+1
如果任何一次翻转已经越界了，证明不可能存在结果了，直接返回-1

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n];
        int flips = 0, res = 0;
        for (int i = 0; i < n; i++) {
            flips += diff[i];
            if (nums[i] + flips % 2 == 1) continue;
            if (i + k - 1 >= n) return -1;
            flips++;
            if (i + k < n) diff[i + k] -= 1;
            res++;
        }
        return res;
    }
}