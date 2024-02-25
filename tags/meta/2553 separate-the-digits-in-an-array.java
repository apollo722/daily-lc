/*
https://leetcode.com/problems/separate-the-digits-in-an-array/

逐个元素处理就好
如果不用list存储结果，就需要先扫描一遍查一下总共有多少个数字
之后再扫一遍得出结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i];
            if (cur == 0) {
                list.add(cur);
                continue;
            }
            while (cur > 0) {
                list.add(cur % 10);
                cur /= 10;
            } 
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - 1 - i);
        }
        return res;
    }
}