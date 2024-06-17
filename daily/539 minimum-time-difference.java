/*
https://leetcode.com/problems/minimum-time-difference/

都转化成分钟之后排序
因为总共分钟数是有限的，最大1440，所以也可以桶排序O(n)

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        int n = timePoints.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            arr[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            res = Math.min(res, arr[i] - arr[i - 1]);
        }
        res = Math.min(res, arr[0] + 24 * 60 - arr[n - 1]);
        return res;
    }
}