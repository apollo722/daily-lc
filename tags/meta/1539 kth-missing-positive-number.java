/*
https://leetcode.com/problems/kth-missing-positive-number/

二分查找，每个位置如果从1开始填满的话，应该是mid+1
空缺数字的个数即为arr[mid]-(mid+1)
如果个数小于k，证明所求的数在后面，左移窗口，反之右移
最后跳出循环的时候r+1=l，而最后的结果一定是在arr[r]与arr[l]之间
arr[r]前缺失的数字个数为arr[r]-(r+1)，所以第k个缺失的数字即为从arr[r]开始的第k-(arr[r]-(r+1))个
即arr[r]+(k-(arr[r]-(r+1)) = k + r + 1
必须要用最后简化后的结果，因为r可能超过arr范围（比如l=0,r=-1），所以结果不能有arr[r]

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) < k) l = mid + 1;
            else r = mid - 1;
        }
        // arr[r] + k - (arr[r] - (r + 1));
        return k + r + 1;
    }
}