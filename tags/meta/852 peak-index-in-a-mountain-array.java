/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/

二分查找，因为题目给定结果一定存在，所以可以从[1,n-2]中查找
如果走到最后l+1=r时，检查的就是1或者n-2处，结果必然存在于二者之中

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if (arr[mid] < arr[mid + 1]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}