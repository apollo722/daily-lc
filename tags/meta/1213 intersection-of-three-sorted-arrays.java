/*
https://leetcode.com/problems/intersection-of-three-sorted-arrays/

对于每个元素在其它的两个数组里二分查找看是否存在即可

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        for (int num : arr1) {
            int idx1 = search(arr2, num);
            if (idx1 == -1) continue;
            int idx2 = search(arr3, num);
            if (idx2 == -1) continue;
            res.add(num);
        }
        return res;
    }

    private int search(int[] arr, int tar) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}