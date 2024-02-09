/*
https://leetcode.com/problems/total-hamming-distance/

如果检查每对pair显然太慢了
两个数只要有一个位置不同，那么就会形成一对pair
如果检查整型32位的每一位，统计每一位有多少数字在此位是1，假设为k，那么在此位不是1的个数就是n-k
也就是k个数和n-k个数会形成k(n-k)个数对，那么在此位上汉明距离就是k(n-k) x 1
对32位的每一位都这样处理即可以求出总汉明距离，这样只循环了32n次，约等于线性复杂度

Time: O(n)，int的位数是固定的32
Space: O(1)
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] m = new int[32];
        for (int num : nums) {
            int pos = 0;
            while (num > 0) {
                m[pos] += (num & 1);
                num >>= 1;
                pos++;
            }
        }
        int res = 0, n = nums.length;
        for (int num : m) {
            res += (n - num) * num;
        }
        return res;
    }
}