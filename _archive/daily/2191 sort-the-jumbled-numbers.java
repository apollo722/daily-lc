/*
https://leetcode.com/problems/sort-the-jumbled-numbers/

代码题，按照mapping转化后再排序即可
要保留对原数字idx的map以方便找到原来的数字是什么

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i], digit = 1, cur = 0;
            if (num == 0) {
                arr.add(new int[]{mapping[num], i});
                continue;
            }
            while (num != 0) {
                cur += mapping[num % 10] * digit;
                digit *= 10;
                num /= 10;
            }
            arr.add(new int[]{cur, i});
        }
        Collections.sort(arr, (a, b) -> a[0] - b[0]);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[arr.get(i)[1]];
        }
        return res;
    }
}