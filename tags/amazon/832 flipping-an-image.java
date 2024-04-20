/*
https://leetcode.com/problems/flipping-an-image/

代码题，注意每行中间的元素也要做01转换

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length, n = image[0].length;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int t = image[i][l] - 1;
                image[i][l] = Math.abs(image[i][r] - 1);
                image[i][r] = Math.abs(t);
                l++;
                r--;
            }
        }
        return image;
    }
}