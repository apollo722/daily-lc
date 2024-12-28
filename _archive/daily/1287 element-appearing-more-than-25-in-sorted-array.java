/*
https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

利用排序特性，频率严格大于25%数一定是n/4，n/2，与3n/4之中的一个，因为必然要在这三个位置中的一个有overlap
所以分别二分查找找到这三个数的左右端点看是否大于n/4.0即可

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] nums = new int[]{arr[n / 4], arr[n / 2], arr[3 * n / 4]};
        for (int num : nums) {
            int l = findLeft(arr, num), r = findRight(arr, num);
            if (r - l + 1 > n / 4.0) return num;
        }
        return -1;
    }

    private int findLeft(int[] arr, int tar) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < tar) l = mid + 1;
            else if (arr[mid] > tar) r = mid - 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    private int findRight(int[] arr, int tar) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < tar) l = mid + 1;
            else if (arr[mid] > tar) r = mid - 1;
            else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}