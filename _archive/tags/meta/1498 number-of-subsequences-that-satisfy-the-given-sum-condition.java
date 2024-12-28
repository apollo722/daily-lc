/*
https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

如果能找到所有的min和max pair，就能求出结果
怎么高效的确定每一对valid pair呢？可以先排序，这样固定左边后，右边的位置可以决定什么位置开始满足条件
如果固定一个最小值l，那么找到一个最大的满足条件的r，那么所有l到r的元素就都可以满足了
l到r间总共有r-l+1个元素，因为固定l，所以不算l，总共r-l个元素，总共有2^(r-l)种取值方法（就算都不取，还剩下个l）
所以对于每一个l，找到r之后，就可以把2^(r-l)放到结果中
可以用二分查找固定l找到r，也可以直接two ptr，因为当l增大时，r一定要减小才能满足条件
所以当一对l+r满足条件时，增加l，否则减少r
如果每次都要计算2^(r-l)就会很慢，所以用一个数组来存储所有的power of 2的值，类似preSum，这样2^(r-l)可以直接通过preSum的数组来获得，不用调用pow公式来算

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int) 1e9 + 7, n = nums.length;
        int l = 0, r = n - 1;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        int res = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res += pow[r - l];
                res %= mod;
                l++;
            } else r--;
        }
        return res;
    }
}