/*
https://leetcode.com/problems/height-checker/

复制一份排序之后逐个对比即可

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = heights.clone();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != arr[i]) res++;
        }
        return res;
    }
}