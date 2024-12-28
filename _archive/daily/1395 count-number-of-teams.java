/*
https://leetcode.com/problems/count-number-of-teams/

对每一个idx，把它想成中间的那个人
统计左边和右边分别有多少个比它大/小的，相乘即可

Time: O(n^2)
Space: O(1)
*/

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int mid = 0; mid < n; mid++) {
            int leftSmaller = 0;
            int rightLarger = 0;

            for (int left = mid - 1; left >= 0; left--) {
                if (rating[left] < rating[mid]) {
                    leftSmaller++;
                }
            }

            for (int right = mid + 1; right < n; right++) {
                if (rating[right] > rating[mid]) {
                    rightLarger++;
                }
            }
            res += leftSmaller * rightLarger;

            int leftLarger = mid - leftSmaller;
            int rightSmaller = n - mid - 1 - rightLarger;

            res += leftLarger * rightSmaller;
        }
        return res;
    }
}